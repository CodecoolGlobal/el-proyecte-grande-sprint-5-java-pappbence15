package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginAttempt {
    private final String username;
    private final String password;
}
