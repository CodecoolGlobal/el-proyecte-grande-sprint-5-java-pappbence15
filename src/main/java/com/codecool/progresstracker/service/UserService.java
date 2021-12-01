package com.codecool.progresstracker.service;


import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;
    public final UUID TEST_ADMIN_ID;


    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
        this.TEST_ADMIN_ID = addTestAdmin();
    }


    public User getTestAdmin() {
        return userDao.getById(TEST_ADMIN_ID);
    }

    public UUID addTestAdmin(){
        User fakeAdmin = new User(UserType.ADMIN, "John McBoss", "john123", "john123");
        userDao.add(fakeAdmin);
        return fakeAdmin.getId();
    }
}
