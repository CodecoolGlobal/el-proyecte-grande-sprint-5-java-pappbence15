package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;

import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserStoryController {

    private final UserStoryService userStoryService;
    private final ProjectService projectService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService,
                               ProjectService projectService) {
        this.userStoryService = userStoryService;
        this.projectService = projectService;
    }

    @PostMapping("/{storyId}/favourite/{isFavourite}")
    public void toggleFavourite(@PathVariable UUID storyId, @PathVariable boolean isFavourite){
        userStoryService.toggleFavourite(storyId, isFavourite);
    }

    @PostMapping("/userstory/add/{projectId}")
    public void addNewUserStoryToProject(@PathVariable("projectId") UUID projectId,
                                         @RequestBody UserStory userStory) {
        projectService.addUserStoryToProject(projectId, userStory);
    }
}
