package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    private final UserService userService;

    public LandingPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcomePage() {

        User user = userService.getLoggedInUser();

        if (user.getUserType().equals(UserType.ADMIN)){
            return "redirect:/admin/projects";
        } else if (user.getUserType().equals(UserType.PRODUCT_OWNER)){
            return "redirect:/admin/projects";
        }

        return "welcome";
    }
}
