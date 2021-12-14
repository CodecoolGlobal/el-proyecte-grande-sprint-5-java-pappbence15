package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
public class User {
    private final UUID id = UUID.randomUUID();
    private UserType userType;
    private String name;
    private String userName;
    private String password;
    private Map<String, Boolean> userSettings;

    public void addSetting(String name, boolean value){
        this.userSettings.put(name, value);
    }

    public boolean doesPasswordMatch(String password){
        return Objects.equals(this.password, password);
    }
}
