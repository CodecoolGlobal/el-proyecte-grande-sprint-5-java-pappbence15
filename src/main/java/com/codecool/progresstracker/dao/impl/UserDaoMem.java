package com.codecool.progresstracker.dao.impl;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoMem implements UserDao {
    private final List<User> users;

    public UserDaoMem() {
        users = new ArrayList<>();
    }

    @Override
    public User find(UUID id){
        for (User user : users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User find(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getValidLoginUser(LoginAttempt loginAttempt){

        User user = find(loginAttempt.getUsername());

        if (user != null){
            if (user.doesPasswordMatch(loginAttempt.getPassword())){
                return user;
            }
        }
        return null;
    }


    //TODO TEST -> delete
    @Override
    public List<User> getAll() {
        return users;
    }

}
