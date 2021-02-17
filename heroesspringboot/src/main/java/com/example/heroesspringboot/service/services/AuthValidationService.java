package com.example.heroesspringboot.service.services;

import com.example.heroesspringboot.service.models.RegisterServiceUserModel;
import org.springframework.stereotype.Service;

@Service
public interface AuthValidationService {
    boolean isValid(RegisterServiceUserModel user);
}
