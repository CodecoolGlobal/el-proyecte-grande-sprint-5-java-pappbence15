package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginPageController {

    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final ProjectService projectService; //like here

    @Autowired
    public LoginPageController(UserDao userDao, ProjectService projectService) {
        this.userDao = userDao;
        this.projectService = projectService;
    }

    @GetMapping
    public String loginPage(){
        return "getLoginPage";
    }

    @PostMapping
    public String loginUser(@RequestBody LoginAttempt loginAttempt){
        User loginUser = userDao.getValidLoginUser(loginAttempt);
        if (loginUser != null){
            return "logged in";
        }else{
            return "Invalid username or password";
        }
    }
}
