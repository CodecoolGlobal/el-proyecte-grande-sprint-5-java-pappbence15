package com.codecool.progresstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
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
    @OneToOne(cascade = {CascadeType.ALL})
    private UserSettings userSettings;

    public User(UserType userType, String name, String userName, String email, String password, UserSettings userSettings) {
        this.userType = userType;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userSettings = userSettings;
    }

    public boolean doesPasswordMatch(String password){
        return Objects.equals(this.password, password);
    }
}
