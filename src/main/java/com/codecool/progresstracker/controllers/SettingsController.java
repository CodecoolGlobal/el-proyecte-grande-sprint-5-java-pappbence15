package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserSettings;
import com.codecool.progresstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@CrossOrigin("http://localhost:3000")
public class SettingsController {

    private final UserService userService;

    @Autowired
    SettingsController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/settings")
    public ResponseEntity<?> getSettings() {
        User currentUser = userService.getLoggedInUser();
        return new ResponseEntity<>(userService.getUserSettings(currentUser.getId()), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/settings/update")
    public void setSettings(@RequestBody UserSettings newUserSettings) {
        userService.updateUserSettings(newUserSettings);
    }
}
