package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.data_sample.CreateMockData;
import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import com.codecool.progresstracker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class MockController {

    private final UserService userService;
    private final ProjectService projectService;
    private final UserStoryService userStoryService;

    @Autowired
    public MockController(UserService userService,
                          ProjectService projectService,
                          UserStoryService userStoryService) {

        this.projectService = projectService;
        this.userService = userService;
        this.userStoryService = userStoryService;
    }

    @PostMapping("/init")
    public void init() throws ParseException {
        CreateMockData createMockData = new CreateMockData(userService, projectService, userStoryService);
        createMockData.spamMockData();
    }

}
