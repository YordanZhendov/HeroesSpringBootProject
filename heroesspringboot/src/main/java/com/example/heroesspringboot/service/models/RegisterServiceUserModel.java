package com.example.heroesspringboot.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterServiceUserModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
