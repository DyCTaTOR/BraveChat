package ru.bravechat.main.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/secured")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SecuredController {

    @GetMapping("/user")
    @Operation(description = "Получение имени аутентифицированного в системе пользователя")
    public String userAccess(Principal principal) {
        if (principal == null) {
            return "Unauthorized";
        }
        return principal.getName();
    }
}
