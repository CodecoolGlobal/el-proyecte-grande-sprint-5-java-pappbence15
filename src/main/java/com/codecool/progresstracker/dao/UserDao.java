package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User find(UUID id);
    User find(String username);
    void add(User user);
    List<User> getAll();
    User getFirstUser();
    User getValidLoginUser(LoginAttempt loginAttempt);
}
