package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.LoginAttempt;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserDaoMem implements UserDao{
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
        createMockUsers();

        User user = find(loginAttempt.getUsername());

        if (user != null){
            if (user.doesPasswordMatch(loginAttempt.getPassword())){
                return user;
            }
        }
        return null;
    }

    public void createMockUsers(){
        users.add(new User(UserType.SUPER_USER, "a","a","a"));
        users.add(new User(UserType.SUPER_USER, "b","b","b"));
        users.add(new User(UserType.SUPER_USER, "c","c","c"));
        users.add(new User(UserType.SUPER_USER, "d","d","d"));
    }
}
