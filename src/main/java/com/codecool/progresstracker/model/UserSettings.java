package com.codecool.progresstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UserSettings {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private boolean darkMode=false;
    private boolean notifications=false;
}
