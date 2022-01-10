package com.codecool.progresstracker.model;

import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.ProjectGoal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    @OneToMany
    private List<UserStory> userStories;
    @ManyToOne
    private User owner;
    @OneToMany
    private List<User> admins;
    @OneToMany
    private List<Goal> projectGoals;

    public UserStory findStory(UUID storyId) throws NullPointerException{
        for (UserStory userStory: userStories) {
            if (userStory.getId().equals(storyId)){
                return userStory;
            }
        }
        throw new NullPointerException("No userStory found with given id.");
    }

    public double getPercentage(){
        if (userStories.size()==0){
            return 0;
        }
        return userStories.stream().map(UserStory::getCurrentPercent).reduce(0.0, Double::sum)
                / userStories.size();
    }

    public void addStory(UserStory userStory){
        this.userStories.add(userStory);
    }

    public void addProjectGoal(ProjectGoal projectGoal){
        this.projectGoals.add(projectGoal);
    }

}