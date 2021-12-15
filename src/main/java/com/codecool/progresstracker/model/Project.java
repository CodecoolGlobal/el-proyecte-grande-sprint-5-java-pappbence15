package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Project {
    private final UUID id;
    private final String name;
    private List<UserStory> userStories;
    private final User owner;
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

    public UserStory findStory(UUID storyId) throws NullPointerException{
        for (UserStory userStory: userStories) {
            if (userStory.getId().equals(storyId)){
                return userStory;
            }
        }
        throw new NullPointerException("No userStory found with given id.");
    }
}