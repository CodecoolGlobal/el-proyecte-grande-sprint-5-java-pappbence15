package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterPageController {

    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final ProductService productService; //like here

    @Autowired
    public RegisterPageController(UserDao userDao, ProductService productService) {
        this.userDao = userDao;
        this.productService = productService;
    }

    @GetMapping
    public String registerPage(Model model){
        model.addAttribute("fancyUserTypes", getFancyUserTypes());

        return "register get";
    }

    public List<String> getFancyUserTypes(){
        List<String> fancyUserTypes = new ArrayList<String>();
        fancyUserTypes.add(UserType.SUPER_USER.getFancyUserType());
        fancyUserTypes.add(UserType.ADMIN.getFancyUserType());

        return fancyUserTypes;
    }

    @PostMapping
    public String registerNewUser(@RequestBody User user, Model model){
        userDao.add(user);

        return "registered user";
    }
}
