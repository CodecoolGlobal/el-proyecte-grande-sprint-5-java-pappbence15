package com.codecool.progresstracker.controllers.data_sample;

import com.codecool.progresstracker.dao.GoalDao;
import com.codecool.progresstracker.model.Goal;
import com.codecool.progresstracker.model.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Component
public class GoalCreator {
    private GoalDao goalDao;

    @Autowired
    public GoalCreator(GoalDao goalDao){
        this.goalDao = goalDao;
    }

    public void initialize(String text, Statuses status, Date deadline){
        Goal goal = new Goal();

        goal.setId(UUID.randomUUID());
        goal.setText(text);
        goal.setStatus(status);
        goal.setDeadline(deadline);

        goalDao.add(goal);
    }
}
