package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;
    private final ProjectDao projectDao;

    @Autowired
    public ProjectController(UserService userService, ProjectService projectService, ProjectDao projectDao) {
        this.userService = userService;
        this.projectService = projectService;
        this.projectDao = projectDao;
    }

    @ResponseBody
    @GetMapping("/admin/projects")
    public ResponseEntity<?> adminProjectsView() throws ParseException {
        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();

        if(userType.equals(UserType.ADMIN)){
            return new ResponseEntity<>(projectService.getProjectsByAdmin(user), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Unauthorized: you are not logged in as an admin", HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseBody
    @GetMapping("/owner/projects")
    public ResponseEntity<?> ownerProjectsView(){
        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();
        if(userType.equals(UserType.PROJECT_OWNER)){
            List<Project> projects = projectService.getProjectsByOwner(user);
            return new ResponseEntity<>(projects, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Unauthorized: you are not logged in as a project owner", HttpStatus.UNAUTHORIZED);        }
    }

    @ResponseBody
    @PostMapping("/project/add")
    public void saveNewProject(@RequestBody Project project) {
//        User user = userService.getLoggedInUser(); TODO make this work with session.
        User user = userService.getAll().get(0);
        if (user.getUserType().equals(UserType.ADMIN)) {
            project.getAdmins().add(user);
        } else if (user.getUserType().equals(UserType.PROJECT_OWNER)) {
            project.setOwner(user);
        }
        projectService.saveProject(project);
    }

    @ResponseBody
    @PostMapping("/project/addAdmin")
    public void addNewAdminToProject(@RequestBody String email) {
        User admin = userService.getUserByEmail(email);
        Project project = projectService.find(projectService.getAll().get(0).getId());
        project.getAdmins().add(admin);
        projectService.saveProject(project);
    }
}
