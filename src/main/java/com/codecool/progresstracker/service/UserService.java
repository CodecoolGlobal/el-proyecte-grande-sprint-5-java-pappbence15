package com.codecool.progresstracker.service;

import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserSettings;

import com.codecool.progresstracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private User loggedInUser;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.saveAndFlush(newUser);
    }

    public void updateUserSettings(UserSettings newUserSettings){
        userRepository.updateUserSettings(loggedInUser.getId(), newUserSettings);
    }

    public UserSettings getUserSettings(UUID userID){
        return userRepository.getUserSettings(userID);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public User getValidLoginUser(LoginAttempt loginAttempt) {
        User user = userRepository.getUserByUserName(loginAttempt.getUsername());
        if (user!=null) {
            if (user.doesPasswordMatch(loginAttempt.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
}
