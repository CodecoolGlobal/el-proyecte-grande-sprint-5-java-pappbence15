package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Goal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GoalDaoMem implements GoalDao{
    private final List<Goal> goalList;

    public GoalDaoMem(){
        this.goalList = new ArrayList();
    }

    @Override
    public void add(Goal goal){
        this.goalList.add(goal);
    }

    @Override
    public Goal find(UUID id) throws NullPointerException{
        for (Goal goal : goalList) {
            if (goal.getId() == id){
                return goal;
            }
        }
        throw new NullPointerException("Goal not found.");
    }
}
