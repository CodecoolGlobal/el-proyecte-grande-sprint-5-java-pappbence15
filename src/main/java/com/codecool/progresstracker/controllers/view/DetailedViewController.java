package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class DetailedViewController {

    private final ProjectService projectService;

    @Autowired
    DetailedViewController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/detailedProjectFeed")
    public String projectPage(@RequestBody User user){
        return null;
    }

    @PostMapping("/detailedProjectFeed/update")
    public void changeDetails(@RequestBody Boolean isFavourite,
                                @RequestBody int currentProgress,
                                @RequestBody UUID userStoryId,
                                @RequestBody UUID projectId) throws Exception {
        projectService.updateUserStory(isFavourite, currentProgress, userStoryId, projectId);
    }
/*
    @PutMapping("/detailedProjectFeed/add")
    public void addNewUserStory(@RequestBody UserStory userStory,
                                @RequestBody Project project) throws Exception {
        projectService.addNewUserStory(userStory, project);
    }*/
    //TODO what is this?
}
