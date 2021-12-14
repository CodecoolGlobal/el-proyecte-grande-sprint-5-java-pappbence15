package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginAttempt {
    private final String username;
    private final String password;

    public LoginAttempt(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
