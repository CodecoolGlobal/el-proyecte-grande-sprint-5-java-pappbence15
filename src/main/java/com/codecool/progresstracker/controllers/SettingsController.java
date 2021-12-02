package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.UUID;

@Controller
public class SettingsController {

    private final UserService userService;

    @Autowired
    SettingsController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/settings")
    public Map<String, Boolean> getSettings(@RequestBody UUID userId){
        return userService.getUserSettings(userId);
    }

    @PostMapping("/{userName}/settings")
    public String setSettings(@PathVariable String userName){
        //todo: set user's settings accordingly
        return null;
    }
}
