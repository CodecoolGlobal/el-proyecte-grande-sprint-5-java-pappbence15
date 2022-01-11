package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.GoalDao;
import com.codecool.progresstracker.data_sample.GoalCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.GoalType;
import com.codecool.progresstracker.model.goal.ProjectGoal;
import com.codecool.progresstracker.model.goal.UserStoryGoal;

import com.codecool.progresstracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository= goalRepository;
    }

    public Goal findGoal(UUID id) {
        return goalRepository.getById(id);
    }

//    public void createNewUserStoryGoal(String text, Statuses status, Date deadline, UserStory userStory){
//        GoalCreator goalCreator= new GoalCreator(goalDao);
//
//        goalCreator.initializeUserStoryGoal(
//                text,
//                status,
//                deadline,
//                userStory
//        );
//    }

//    public void createNewProjectGoal(String text, Statuses status, Date deadline,Project project){
//        GoalCreator goalCreator= new GoalCreator(goalDao);
//
//        goalCreator.initializeProjectGoal(
//                text,
//                status,
//                deadline,
//                project
//        );
//    }

    public void updateGoal(UUID id, String text, Statuses status, Date deadLine, GoalType goalType) {
        goalRepository.updateGoal(deadLine, goalType, status, text, id);
    }
}
