package com.codecool.progresstracker;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/login")
public class LoginPageController {

    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final ProductService productService; //like here

    @Autowired
    public LoginPageController(UserDao userDao, ProductService productService) {
        this.userDao = userDao;
        this.productService = productService;
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
