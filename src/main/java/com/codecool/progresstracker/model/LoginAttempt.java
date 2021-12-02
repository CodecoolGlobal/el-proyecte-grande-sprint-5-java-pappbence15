package com.codecool.progresstracker.model;

public class LoginAttempt {
    private final String username;
    private final String password;

    public LoginAttempt(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
