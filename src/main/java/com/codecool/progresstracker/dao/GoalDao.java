package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.goal.ProjectGoal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;

import java.util.UUID;

public interface GoalDao {
    void add(ProjectGoal projectGoal);
    void add(UserStoryGoal userStoryGoal);

    UserStoryGoal findUserStoryGoal(UUID id) throws NullPointerException;
    ProjectGoal findProjectGoal(UUID id) throws NullPointerException;
}
