package com.codecool.progresstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    @GetMapping("/{userName}/settings")
    public String getSettings(@PathVariable String userName){
        //todo: return user's settings
        return null;
    }

    @PostMapping("/{userName}/settings")
    public String setSettings(@PathVariable String userName){
        //todo: set user's settings accordingly
        return null;
    }
}
