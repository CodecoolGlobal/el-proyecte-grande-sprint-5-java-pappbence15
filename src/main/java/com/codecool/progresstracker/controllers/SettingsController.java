package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
public class SettingsController {

    private final UserService userService;

    @Autowired
    SettingsController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/settings")
    public ResponseEntity<?> getSettings() {
        return new ResponseEntity<>(userService.getLoggedInUser().getUserSettings(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/settings/darkMode")
    public ResponseEntity<?> getThemeSetting(){
        return new ResponseEntity<>(userService.getLoggedInUser().getUserSettings().get("darkMode"), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/settings/update/{key}/{value}")
    public void setSettings(@PathVariable String key, @PathVariable String value) {
        boolean newValue;
        newValue = Objects.equals(value, "true");
        userService.updateUserSettings(key, newValue);
    }
}
