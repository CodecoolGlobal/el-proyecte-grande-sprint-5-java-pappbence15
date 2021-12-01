package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationHandler {

    private final UserDao userDao;

    @Autowired
    public RegistrationHandler(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String username, String name, String password, String newUserType){
        UserType userType = stringToUserTypeConverter(newUserType);
        User newUser = new User(userType, name, username, password);
        userDao.add(newUser);
    }

    public UserType stringToUserTypeConverter (String userType){
        switch(userType){
            case "ADMIN":
                return UserType.ADMIN;
            case "SUPER_USER":
                return UserType.SUPER_USER;
            default:
                return UserType.PRODUCT_OWNER;
        }
    }
}
