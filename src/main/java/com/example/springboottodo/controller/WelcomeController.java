package com.example.springboottodo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
    @GetMapping("/")
    public String goToWelcome(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    // to handle request param e.g. name = ABC we use @RequestParam
    // when we want to pass something from controller to view we use MODEl
    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
