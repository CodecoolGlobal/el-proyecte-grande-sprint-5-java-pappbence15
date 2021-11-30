package com.codecool.progresstracker;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class OverviewController {
    UserDao userDao;

    @Autowired
    public OverviewController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/newsfeed")
    public String productPage(Model model){
        User user = userDao.getFirstUser();
        model.addAttribute("user", user);
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
