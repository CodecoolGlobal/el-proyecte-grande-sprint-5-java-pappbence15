package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.data_sample.UserCreator;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserDao userDao;

    @Autowired
    public RegistrationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String username, String name, String password, String newUserType){
        UserType userType = stringToUserTypeConverter(newUserType);

        UserCreator userCreator = new UserCreator(userDao);

        userCreator.initialize(userType, name, username, password);
    }

    public UserType stringToUserTypeConverter (String userType){
        switch(userType){
            case "ADMIN":
                return UserType.ADMIN;
            case "SUPER_USER":
                return UserType.SUPER_USER;
            default:
                return UserType.PROJECT_OWNER;
        }
    }
}
