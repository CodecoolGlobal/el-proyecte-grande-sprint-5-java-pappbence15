package com.codecool.progresstracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String welcomePage(){
        return "welcome";
    }


}
