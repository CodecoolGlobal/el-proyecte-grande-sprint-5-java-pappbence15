package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.data_sample.UserCreator;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;
    private User loggedInUser;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Map<String, Boolean> getUserSettings(UUID userId){
        User user = userDao.find(userId);
        return user.getUserSettings();
    }

    public void createNewUser(UserType userType, String name, String username, String email, String password){
        UserCreator userCreator = new UserCreator(userDao);

        userCreator.initialize(userType, name, username, email, password);
    }

    public void updateUserSettings(String key, boolean value){
        Map<String, Boolean> userSettings = getLoggedInUser().getUserSettings();
        boolean oldValue = userSettings.get(key);
        userSettings.replace(key, oldValue, value);
    }


    //TODO TEST -> DELETE
    public List<User> getAll(){
        return userDao.getAll();
    }
}
