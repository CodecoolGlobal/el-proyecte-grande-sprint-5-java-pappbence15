package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;

import com.codecool.progresstracker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserStoryController {
    private final UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @PostMapping("/{storyId}/favourite/{isFavourite}")
    public void toggleFavourite(@PathVariable UUID storyId, @PathVariable boolean isFavourite){
        userStoryService.toggleFavourite(storyId, isFavourite);
    }

}
