package com.example.heroesspringboot.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginUserServiceModel {
    private String userName;
    private String heroName;

    public LoginUserServiceModel(String username, String heroName) {
        this.heroName=username;
        this.heroName=heroName;
    }
}
