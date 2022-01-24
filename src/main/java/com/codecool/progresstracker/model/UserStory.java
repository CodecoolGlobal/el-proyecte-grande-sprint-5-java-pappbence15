package com.codecool.progresstracker.model;

import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserStory {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private double currentPercent;
    private boolean isFavourite;
    @OneToMany
    private List<Goal> userStoryGoals;

    public UserStory(String name, double currentPercent, boolean isFavourite) {
        this.name = name;
        this.currentPercent = currentPercent;
        this.isFavourite = isFavourite;
    }

    public void add(UserStoryGoal userStoryGoal){
        this.userStoryGoals.add(userStoryGoal);
    }

    public void setCurrentPercent(int currentPercent) {
        this.currentPercent = currentPercent;
    }
}