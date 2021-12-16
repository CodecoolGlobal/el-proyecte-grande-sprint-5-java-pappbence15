package com.codecool.progresstracker.dao.impl;

import com.codecool.progresstracker.model.goal.ProjectGoal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.progresstracker.dao.GoalDao;
import com.codecool.progresstracker.model.Goal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GoalDaoMem implements GoalDao{
    private final List<UserStoryGoal> userStoryGoals;
    private final List<ProjectGoal> projectGoals;

    @Autowired
    public GoalDaoMem(){
        this.userStoryGoals = new ArrayList<UserStoryGoal>();
        this.projectGoals = new ArrayList<ProjectGoal>();
    }

    @Override
    public void add(ProjectGoal projectGoal){
        this.projectGoals.add(projectGoal);
    }

    @Override
    public void add(UserStoryGoal userStoryGoal){
        this.userStoryGoals.add(userStoryGoal);
    }

    @Override
    public ProjectGoal findProjectGoal(UUID id) throws NullPointerException{
        for (ProjectGoal projectGoal : projectGoals) {
            if (projectGoal.getId() == id){
                return projectGoal;
            }
        }
        throw new NullPointerException("Goal not found.");
    }

    @Override
    public UserStoryGoal findUserStoryGoal(UUID id) throws NullPointerException{
        for (UserStoryGoal userStoryGoal : userStoryGoals) {
            if (userStoryGoal.getId() == id){
                return userStoryGoal;
            }
        }
        throw new NullPointerException("Goal not found.");
    }
}
