package com.codecool.progresstracker.model;


public class User {
    private final UserType userType;
    private final String name;
    private final String userName;
    private final String password;

    public User(UserType userType, String name, String userName, String password) {
        this.userType = userType;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }
}
