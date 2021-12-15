package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Goal;

import java.util.UUID;

public interface GoalDao {

    void add(Goal goal);
    Goal find(UUID id);
}
