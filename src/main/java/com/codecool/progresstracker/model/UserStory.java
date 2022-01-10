package com.codecool.progresstracker.model;

import com.codecool.progresstracker.model.goal.UserStoryGoal;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserStory {
    private final UUID id;
    private final String name;
    private double currentPercent;
    private boolean isFavourite;
    private List<UserStoryGoal> userStoryGoals;

    public void add(UserStoryGoal userStoryGoal){
        this.userStoryGoals.add(userStoryGoal);
    }

    public void setCurrentPercent(int currentPercent) {
        this.currentPercent = currentPercent;
    }
}