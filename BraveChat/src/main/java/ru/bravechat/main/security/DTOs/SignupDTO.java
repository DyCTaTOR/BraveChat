package ru.bravechat.main.security.DTOs;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SignupDTO {
    private String username;
    private String name;
    private String phone;
    private LocalDate birthday;
    private String password;
}
