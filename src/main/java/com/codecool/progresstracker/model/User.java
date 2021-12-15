package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private final UUID id;
    private final UserType userType;
    private final String name;
    private final String userName;
    private String password;
    private Map<String, Boolean> userSettings;

    public void addSetting(String name, boolean value){
        this.userSettings.put(name, value);
    }

    public boolean doesPasswordMatch(String password){
        return Objects.equals(this.password, password);
    }
}
