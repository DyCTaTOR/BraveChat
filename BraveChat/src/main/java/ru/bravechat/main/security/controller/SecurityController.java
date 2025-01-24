package ru.bravechat.main.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bravechat.main.security.DTOs.SigninDTO;
import ru.bravechat.main.security.DTOs.SignupDTO;
import ru.bravechat.main.security.jwt.JWTCore;
import ru.bravechat.main.user.model.AppUser;
import ru.bravechat.main.user.repo.AppUserRepo;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class SecurityController {

    private final AppUserRepo appUserRepo;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JWTCore jwtCore;

    @PostMapping("/signin")
    @Operation(description = "Аутентификация в системе")
    ResponseEntity<?> signin(@RequestBody SigninDTO signinDTO) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinDTO.getUsername(), signinDTO.getPassword()));
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    @SneakyThrows
    @Operation(description = "Регистрация в системе")
    ResponseEntity<?> signup(@RequestBody SignupDTO signupRequest) {
        if (appUserRepo.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пользователь с данным именем уже существует");
        }
        if (appUserRepo.existsByPhone(signupRequest.getPhone())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пользователь с данным номером телефона уже существует");
        }
        String hashed = passwordEncoder.encode(signupRequest.getPassword());
        AppUser newUser = AppUser.builder()
                .name(signupRequest.getName())
                .phone(signupRequest.getPhone())
                .username(signupRequest.getUsername())
                .password(hashed)
                .build();
        appUserRepo.save(newUser);
        return ResponseEntity.ok("OK");
    }
}
