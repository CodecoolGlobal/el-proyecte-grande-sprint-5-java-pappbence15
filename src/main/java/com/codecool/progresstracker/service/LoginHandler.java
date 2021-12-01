package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.util.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHandler {

    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final ProductService productService; //like here
    private final PasswordHandler passwordHandler;

    @Autowired
    public LoginHandler(UserDao userDao, ProductService productService, PasswordHandler passwordHandler) {
        this.userDao = userDao;
        this.productService = productService;
        this.passwordHandler = passwordHandler;
    }

    public boolean areCredentialsValid(String username, String password){
        User user = userDao.find(username);
        password = passwordHandler.encodePassword(password);

        if (user!= null){
            return passwordHandler.doPasswordsMatch(user.getPassword(), password);
        }

        return false;
    }

}
