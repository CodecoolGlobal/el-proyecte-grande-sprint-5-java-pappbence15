package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserStoryCreator {

    private final UserStoryDao userStoryDao;

    @Autowired
    public UserStoryCreator(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    public void initialize(String name, int max_progress, boolean isFavourite) {
        UserStory userStory = new UserStory(
                UUID.randomUUID(),
                name,
                max_progress,
                0,
                0,
                isFavourite
        );

        userStoryDao.add(userStory);
    }
}
