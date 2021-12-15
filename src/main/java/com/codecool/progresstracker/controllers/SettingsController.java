package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Controller
public class SettingsController {

    private final UserService userService;

    @Autowired
    SettingsController(UserService userService){
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/settings")
    public ResponseEntity<?> getSettings(){
        return new ResponseEntity<>(userService.getLoggedInUser().getUserSettings(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/settings/update/{key}/{value}")
    public void setSettings(@PathVariable String key, @PathVariable String value){
        boolean newValue;
        newValue = Objects.equals(value, "true");
        userService.updateUserSettings(key, newValue);
//        return new ResponseEntity<>(userService.getLoggedInUser().getUserSettings(), HttpStatus.OK);
    }
}
