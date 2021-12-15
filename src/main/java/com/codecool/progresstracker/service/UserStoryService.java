package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.data_sample.UserStoryCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoryService {

    private final UserStoryDao userStoryDao;

    @Autowired
    public UserStoryService(UserStoryDao userStoryDao){
        this.userStoryDao = userStoryDao;
    }

    public void add(Project project, UserStory userStory){
        project.addStory(userStory);
        this.userStoryDao.add(userStory);
    }

    public void createNewUserStory(Project project, String name, int maxProgress, int currentProgress, boolean isFavourite){
        UserStoryCreator userStoryCreator = new UserStoryCreator(userStoryDao);

        userStoryCreator.initialize(project, name, maxProgress, currentProgress, isFavourite);

    }
}
