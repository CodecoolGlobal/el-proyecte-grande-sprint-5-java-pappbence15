package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    void add(User user);
    User find(String username);
    User getFirstUser(); //for testing, until we can get logged in user from session or whatever
    List<User> getAllUsers();
    User getById(UUID id);
}
