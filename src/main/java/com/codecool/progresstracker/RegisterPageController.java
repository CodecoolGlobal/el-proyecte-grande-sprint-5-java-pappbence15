package com.codecool.progresstracker;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterPageController {

    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final ProductService productService; //like here

    @Autowired
    public RegisterPageController(UserDao userDao, ProductService productService) {
        this.userDao = userDao;
        this.productService = productService;
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        User user = (User) model.getAttribute("loggedInUser");

        if (user == null){

            model.addAttribute("fancyUserTypes", getFancyUserTypes());
            return "register";
        }else{
            throw new HttpClientErrorException(HttpStatus.valueOf("AlreadyLoggedIn"));
        }
    }

    public List<String> getFancyUserTypes(){
        List<String> fancyUserTypes = new ArrayList<String>();
        fancyUserTypes.add(UserType.SUPER_USER.getFancyUserType());
        fancyUserTypes.add(UserType.ADMIN.getFancyUserType());
        return fancyUserTypes;
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestBody User user, Model model){


        userDao.add(user);

        model.addAttribute("user", user);
        return "admin-index";
    }
}
