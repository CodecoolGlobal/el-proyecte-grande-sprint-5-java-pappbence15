package com.codecool.progresstracker.service;


import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
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
        return userDao.find(TEST_ADMIN_ID);
    }

    public User getLoggedInUser() {
        return getTestAdmin(); //for now
    }


    public UUID addTestAdmin(){
        User fakeAdmin = new User(UserType.ADMIN, "John McBoss", "john123", "john123");
        userDao.add(fakeAdmin);
        return fakeAdmin.getId();
    }

    public Map<String, Boolean> getUserSettings(UUID userId){
        User user = userDao.find(userId);
        return user.getUserSettings();
    }

    public void updateUserSettings(UUID userId, String key, boolean value){
        Map<String, Boolean> userSettings = userDao.find(userId).getUserSettings();
        boolean oldValue = userSettings.get(key);
        userSettings.replace(key, oldValue, value);
    }
}
