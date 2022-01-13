package com.codecool.progresstracker.model;

import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.ProjectGoal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private String name;
    @OneToMany
    private List<UserStory> userStories;
    @ManyToOne
    private User owner;
    @ManyToMany
    private List<User> admins;
    @OneToMany
    private List<Goal> projectGoals;

    public Project(String name, User owner, List<User> admins) {
        this.name = name;
        this.owner = owner;
        this.admins = admins;
    }

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