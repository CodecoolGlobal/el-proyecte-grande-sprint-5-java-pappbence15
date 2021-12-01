package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.User;
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
    public void add(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getById(UUID id) {
        return users.stream().filter(u->u.getId().equals(id)).toList().get(0);
    }


}
