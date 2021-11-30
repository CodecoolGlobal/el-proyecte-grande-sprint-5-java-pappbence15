package com.codecool.progresstracker;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class OverviewController {
    @GetMapping("/newsfeed")
    public String productPage(@RequestBody User user){
        UserType userType = user.getUserType();
        if(userType.equals(UserType.PRODUCT_OWNER)){
            return "index";
        }else if(userType.equals(UserType.ADMIN)){
            return "admin-index";
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
