package com.example.heroesspringboot.service.services.implementations;

import com.example.heroesspringboot.data.repositories.UserRepository;
import com.example.heroesspringboot.service.models.RegisterServiceUserModel;
import com.example.heroesspringboot.service.services.AuthValidationService;
import org.springframework.stereotype.Service;

@Service
public class AuthValidationServiceImplementation implements AuthValidationService {

    private final UserRepository userRepository;

    public AuthValidationServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(RegisterServiceUserModel user) {
        return this.isEmailValid(user.getEmail()) &&
                this.arePasswordValid(user.getPassword(), user.getConfirmPassword()) &&
                this.isUsernameFree(user.getUsername());
    }

    private boolean arePasswordValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isUsernameFree(String username) {
        return !this.userRepository.existsByUsername(username);
    }

    private boolean isEmailValid(String email) {
        return true;
    }
}
