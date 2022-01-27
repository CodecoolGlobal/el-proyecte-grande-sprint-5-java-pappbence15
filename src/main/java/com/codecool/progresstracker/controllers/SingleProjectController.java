package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@CrossOrigin("http://localhost:3000")
public class SingleProjectController {
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public SingleProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @ResponseBody
    @GetMapping("/admin/project/{projectId}")
    public ResponseEntity<?> adminProjectPage(@PathVariable UUID projectId) {
        return new ResponseEntity<>(projectService.find(projectId), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/owner/project/{projectId}")
    public ResponseEntity<?> ownerProjectPage(@PathVariable UUID projectId) {
        Project project = projectService.find(projectId);

        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();

        if (userType == UserType.PROJECT_OWNER && project.getOwner().equals(user)){
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unauthorized: you are not the owner of this project", HttpStatus.UNAUTHORIZED);
        }
    }
}
