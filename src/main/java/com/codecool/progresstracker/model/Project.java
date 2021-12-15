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
        if (userStories.size()==0){
            return 0;
        }
        double totalStoryPoints = userStories.stream()
                .map(UserStory::getMAX_PROGRESS)
                .reduce(0, Integer::sum);
        double completed = userStories.stream()
                .map(UserStory::getCurrentProgress)
                .reduce(0, Integer::sum);
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

    public void addStory(UserStory userStory){
        this.userStories.add(userStory);
    }
}