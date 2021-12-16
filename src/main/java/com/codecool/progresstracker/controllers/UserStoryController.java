package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserStoryController {
    private final UserStoryDao userStoryDao;

    @Autowired
    public UserStoryController(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    @PostMapping("/{storyId}/favourite")
    public void toggleFavourite(@PathVariable UUID storyId){
        UserStory story = userStoryDao.find(storyId);
        story.setFavourite(!story.isFavourite());
        System.out.println(story.isFavourite());
    }

}
