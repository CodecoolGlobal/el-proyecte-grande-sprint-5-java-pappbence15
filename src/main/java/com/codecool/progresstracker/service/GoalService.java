package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.GoalDao;
import com.codecool.progresstracker.data_sample.GoalCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.model.goal.ProjectGoal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class GoalService {
    private final GoalDao goalDao;

    @Autowired
    public GoalService(GoalDao goalDao) {
        this.goalDao= goalDao;
    }

    public ProjectGoal findProjectGoal(UUID id) throws NullPointerException {
        try {
            return goalDao.findProjectGoal(id);
        }catch(NullPointerException nullPointerException){
            throw new NullPointerException("ProjectGoal not found.");
        }
    }

    public UserStoryGoal findUserStoryGoal(UUID id) throws NullPointerException {
        try {
            return goalDao.findUserStoryGoal(id);
        }catch(NullPointerException nullPointerException){
            throw new NullPointerException("UserStoryNot not found.");
        }
    }

    public void createNewUserStoryGoal(String text, Statuses status, Date deadline, UserStory userStory){
        GoalCreator goalCreator= new GoalCreator(goalDao);

        goalCreator.initializeUserStoryGoal(
                text,
                status,
                deadline,
                userStory
        );
    }

    public void createNewProjectGoal(String text, Statuses status, Date deadline,Project project){
        GoalCreator goalCreator= new GoalCreator(goalDao);

        goalCreator.initializeProjectGoal(
                text,
                status,
                deadline,
                project
        );
    }

    public void updateUserStoryGoal(UUID id, String text, Statuses status, Date deadLine) throws NullPointerException {
        try {
            UserStoryGoal userStoryGoal = goalDao.findUserStoryGoal(id);

            userStoryGoal.setText(text);
            userStoryGoal.setStatus(status);
            userStoryGoal.setDeadline(deadLine);

        }catch(NullPointerException notFoundElement){
            throw new NullPointerException("Item not found during userStory update");
        }
    }
}
