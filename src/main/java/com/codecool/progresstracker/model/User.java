package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private UUID id;
    private UserType userType;
    private String name;
    private String userName;
    private String email;
    private String password;
    private Map<String, Boolean> userSettings;

    public void addSetting(String name, boolean value){
        this.userSettings.put(name, value);
    }

    public boolean doesPasswordMatch(String password){
        return Objects.equals(this.password, password);
    }
}
