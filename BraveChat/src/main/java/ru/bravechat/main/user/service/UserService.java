package ru.bravechat.main.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bravechat.main.user.model.AppUser;
import ru.bravechat.main.user.repo.AppUserRepo;

@Service
public class UserService implements UserDetailsService {
    private AppUserRepo appUserRepo;

    @Autowired
    public void setAppUserRepo(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException(String.format("User %s not found", username)));
        return UserDetailsImpl.build(appUser);
    }
}
