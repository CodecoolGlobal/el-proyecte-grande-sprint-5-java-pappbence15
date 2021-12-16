package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class UserStoryCreator {

    private final UserStoryDao userStoryDao;
    private final int BASE_STATUS = 0;

    @Autowired
    public UserStoryCreator(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    public void initialize(Project project, String name, boolean isFavourite) {
        UserStory userStory = new UserStory(
                UUID.randomUUID(),
                name,
                this.BASE_STATUS,
                isFavourite,
                new ArrayList<>()
        );

        userStoryDao.add(userStory);
        project.addStory(userStory);
    }
}
