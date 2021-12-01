package com.codecool.progresstracker.dao;

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
        addFakeUser();
    }

    @Override
    public User find(UUID id) {
        for (User user : users) {
            if (user.getId() == id){
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
    public List<User> getAll() {
        return this.users;
    }

    //for testing purposes
    public void addFakeUser(){
        User fakeAdmin = new User(UserType.ADMIN, "John McBoss", "john123", "john123");
        this.add(fakeAdmin);
        System.out.println(fakeAdmin.getId());
    }

    @Override
    public User getFirstUser(){
        return this.users.get(0);
    }




}
