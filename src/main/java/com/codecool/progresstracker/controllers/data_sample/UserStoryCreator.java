package com.codecool.progresstracker.controllers.data_sample;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStoryCreator {

    private final UserStoryDao userStoryDao;

    @Autowired
    public UserStoryCreator(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    public void initialize(String name, int max_progress) {
        UserStory userStory = new UserStory();

        userStory.setName(name);
        userStory.setMAX_PROGRESS(max_progress);
        userStory.setCurrentProgress(0);
        userStory.setCurrentPercent(0);
        userStory.setFavourite(false);

        userStoryDao.add(userStory);
    }
}
