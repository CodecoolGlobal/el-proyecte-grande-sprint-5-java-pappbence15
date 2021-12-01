package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User find(UUID id);
    void add(User user);
    List<User> getAll();
    User getFirstUser(); //for testing, until we can get logged in user from session or whatever
}
