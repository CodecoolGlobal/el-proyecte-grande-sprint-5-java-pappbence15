package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;

import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterPageController {

    private final ProjectService projectService;
    private final UserService userService;

    @Autowired
    public RegisterPageController(ProjectService projectService,
                                  UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping
    public String registerPage(Model model){
        model.addAttribute("fancyUserTypes", getFancyUserTypes());

        return "register get";
    }

    public List<String> getFancyUserTypes(){
        List<String> fancyUserTypes = new ArrayList<>();
        fancyUserTypes.add(UserType.SUPER_USER.getFancyUserType());
        fancyUserTypes.add(UserType.ADMIN.getFancyUserType());

        return fancyUserTypes;
    }

    @PostMapping
    public String registerNewUser(@RequestBody User user) {
        userService.saveNewUser(user);
        userService.setLoggedInUser(user);

        return "registered user";
    }
}
