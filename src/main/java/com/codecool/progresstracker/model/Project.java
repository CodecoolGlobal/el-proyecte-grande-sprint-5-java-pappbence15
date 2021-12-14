package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Project {
    private UUID id;
    private String name;
    private List<UserStory> userStories;
    private User owner;
    private List<User> admins;

    public double getPercentage(){
        double totalStoryPoints = userStories.stream()
                .map(UserStory::getMAX_PROGRESS)
                .reduce(0, Integer::sum);
        double completed = userStories.stream()
                .map(story -> story.getMAX_PROGRESS()*story.getCurrentPercent())
                .reduce(0.0, Double::sum);
        return completed / totalStoryPoints;
    }
}