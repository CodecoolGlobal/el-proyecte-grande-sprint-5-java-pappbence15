package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private UserType userType;
    private String name;
    private String userName;
    private String email;
    private String password;
    @OneToOne
    private UserSettings userSettings;

    public User(UserType userType, String name, String username, String email, String password, UserSettings userSettings) {
    }

    public boolean doesPasswordMatch(String password){
        return Objects.equals(this.password, password);
    }
}
