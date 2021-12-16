package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
public class UserCreator {

    private final UserDao userDao;

    @Autowired
    public UserCreator(UserDao userDao){
        this.userDao = userDao;
    }

    public void initialize(UserType userType, String name, String userName, String email, String password) {
        User user = new User(
                UUID.randomUUID(),
                userType,
                name,
                userName,
                email,
                password,
                new HashMap<>()
        );

        user.addSetting("darkMode", false);
        user.addSetting("notifications", false);

        userDao.add(user);
    }
}