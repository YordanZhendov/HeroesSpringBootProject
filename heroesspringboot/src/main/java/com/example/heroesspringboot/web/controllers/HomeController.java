package com.example.heroesspringboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView getIndex(HttpSession session) {
        return new ModelAndView("home/index.html");
    }

    @GetMapping("/home")
    public ModelAndView getHome() {
        return new ModelAndView("home/home.html");
    }
}
