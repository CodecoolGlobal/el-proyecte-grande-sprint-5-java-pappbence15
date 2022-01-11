package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.data_sample.UserCreator;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserSettings;
import com.codecool.progresstracker.model.UserType;

import com.codecool.progresstracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;
    private User loggedInUser;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        loggedInUser = null;
        this.userRepository = userRepository;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void createNewUser(User newUser){
        userRepository.save(newUser);
    }

    public void updateUserSettings(UserSettings newUserSettings){
        userRepository.updateUserSettings(loggedInUser.getId(), newUserSettings);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }
}
