package com.example.heroesspringboot.web.controllers;

import com.example.heroesspringboot.service.models.LoginUserServiceModel;
import com.example.heroesspringboot.service.models.RegisterServiceUserModel;
import com.example.heroesspringboot.service.services.AuthService;
import com.example.heroesspringboot.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("auth/login.html");
    }

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("auth/register.html");
    }


    @PostMapping("/register")
    public ModelAndView createRegister(@ModelAttribute RegisterUserModel model){
        RegisterServiceUserModel serviceModel=this.modelMapper.map(model,RegisterServiceUserModel.class);
        this.authService.register(serviceModel);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/login")
    public ModelAndView createLogin(@ModelAttribute RegisterUserModel model, HttpSession session){
        RegisterServiceUserModel serviceModel=this.modelMapper.map(model,RegisterServiceUserModel.class);
        try {
            LoginUserServiceModel loginUserServiceModel=this.authService.login(serviceModel);
            session.setAttribute("user",loginUserServiceModel);
            return new ModelAndView("redirect:/home");

        } catch (Exception ex) {
            return new ModelAndView("redirect:/users/login");
        }
    }

}

