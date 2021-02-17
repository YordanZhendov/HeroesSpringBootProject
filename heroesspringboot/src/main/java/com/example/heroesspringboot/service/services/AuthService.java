package com.example.heroesspringboot.service.services;

import com.example.heroesspringboot.service.models.LoginUserServiceModel;
import com.example.heroesspringboot.service.models.RegisterServiceUserModel;

public interface AuthService {

    void register(RegisterServiceUserModel model);

    LoginUserServiceModel login(RegisterServiceUserModel servicemodel) throws Exception;
}
