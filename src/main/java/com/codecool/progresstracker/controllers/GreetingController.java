package com.codecool.progresstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GreetingController {

    @GetMapping("greeting")
    public String getGreetingPage() {
        return "greeting";
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }


}
