package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @ResponseBody
    @GetMapping("/admin/projects")
    public List<Project> adminProjectsView(){
        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();
        if(userType.equals(UserType.ADMIN)){
            return projectService.getProjectsByAdmin(user);
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseBody
    @GetMapping("/owner/projects")
    public List<Project> ownerProjectsView(){
        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();
        if(userType.equals(UserType.PROJECT_OWNER)){
            return projectService.getProjectsByOwner(user);
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
