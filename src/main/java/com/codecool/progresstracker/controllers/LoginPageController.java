package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.service.ProjectService;

import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginPageController {

    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public LoginPageController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping
    public String loginPage(){
        return "getLoginPage";
    }

    @PostMapping
    public String loginUser(@RequestBody LoginAttempt loginAttempt){
        User loginUser = userService.getValidLoginUser(loginAttempt);
        if (loginUser != null){
            return "logged in";
        }else{
            return "Invalid username or password";
        }
    }
}
