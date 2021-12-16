package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.GoalDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.goal.ProjectGoal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class GoalCreator {
    private final GoalDao goalDao;

    @Autowired
    public GoalCreator(GoalDao goalDao){
        this.goalDao = goalDao;
    }

    public void initializeProjectGoal(String text, Statuses status, Date deadline, Project project){
        ProjectGoal projectGoal = new ProjectGoal(
                UUID.randomUUID(),
                text,
                status,
                deadline,
                project
        );

        project.addProjectGoal(projectGoal);

        goalDao.add(projectGoal);
    }

    public void initializeUserStoryGoal(String text, Statuses status, Date deadline, UserStory userStory){
        UserStoryGoal userStoryGoal = new UserStoryGoal(
                UUID.randomUUID(),
                text,
                status,
                deadline,
                userStory
        );

        userStory.add(userStoryGoal);
        goalDao.add(userStoryGoal);
    }
}
