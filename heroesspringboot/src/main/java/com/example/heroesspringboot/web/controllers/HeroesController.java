package com.example.heroesspringboot.web.controllers;

import com.example.heroesspringboot.data.entities.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    @GetMapping("/create")
    public ModelAndView getCreateHero(){
        return new ModelAndView("heroes/create-hero.html");
    }

    @GetMapping("/details/{name}")
    public ModelAndView getHeroDetails(@PathVariable String name){
        return new ModelAndView("heroes/heroDetails.html");
    }
}
