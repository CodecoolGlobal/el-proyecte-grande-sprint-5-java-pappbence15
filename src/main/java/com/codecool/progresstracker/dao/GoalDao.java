package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.ProjectGoal;

import java.util.UUID;

public interface GoalDao {
    void add(Goal goal);
    Goal find(UUID id);
}
