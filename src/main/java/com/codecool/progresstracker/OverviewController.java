package com.codecool.progresstracker;

import com.codecool.progresstracker.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OverviewController {
    @GetMapping("/newsfeed")
    public String productPage(@RequestBody User user){
        return null;
    }
}
