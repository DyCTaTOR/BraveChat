package ru.bravechat.main.security.DTOs;

import lombok.Getter;

@Getter
public class SigninDTO {
    private String username;
    private String password;
    private String phone;
}
