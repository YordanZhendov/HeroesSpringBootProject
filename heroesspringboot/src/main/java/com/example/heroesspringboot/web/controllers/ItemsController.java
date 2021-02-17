package com.example.heroesspringboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @GetMapping("/create")
    public ModelAndView getItemCreate(){
        return new ModelAndView("items/create-item.html");
    }

    @GetMapping("/merchant")
    public ModelAndView getMerchant(){
        return new ModelAndView("items/merchant.html");
    }
}
