package com.example.heroesspringboot.service.services.implementations;

import com.example.heroesspringboot.data.entities.User;
import com.example.heroesspringboot.data.repositories.UserRepository;
import com.example.heroesspringboot.service.models.LoginUserServiceModel;
import com.example.heroesspringboot.service.models.RegisterServiceUserModel;
import com.example.heroesspringboot.service.services.AuthService;
import com.example.heroesspringboot.service.services.AuthValidationService;
import com.example.heroesspringboot.service.services.HashingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImplementation implements AuthService {

    private final AuthValidationService authValidationService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HashingService hashingService;

    public AuthServiceImplementation(AuthValidationService authValidationService, UserRepository userRepository, ModelMapper modelMapper, HashingService hashingService) {
        this.authValidationService = authValidationService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterServiceUserModel model) {

        if(!authValidationService.isValid(model)){
            //do sth
            return;
        }

        User user=this.modelMapper.map(model,User.class);
        user.setPassword(this.hashingService.hash(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginUserServiceModel login(RegisterServiceUserModel serviceModel) throws Exception {
        String passwordHash=this.hashingService.hash(serviceModel.getPassword());
        Optional<User> userOptional=this.userRepository.findByUsernameAndPassword(serviceModel.getUsername(),passwordHash);
        if(userOptional.isEmpty()){
            throw new Exception("Invalid User");
        }

        User user=userOptional.get();
        String heroName=user.getHero()==null ? null : user.getHero().getName();
        return new LoginUserServiceModel(serviceModel.getUsername(), heroName);

    }
}
