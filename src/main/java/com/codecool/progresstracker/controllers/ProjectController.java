package com.codecool.progresstracker.controllers;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.ProjectDTO;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }


    @ResponseBody
    @GetMapping("/projects")
    public ResponseEntity<?> adminProjectsView() throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUserName(authentication.getName());
        UserType userType = user.getUserType();

        if(userType.equals(UserType.ADMIN)){
            return new ResponseEntity<>(projectService.getProjectsByAdmin(user), HttpStatus.OK);
        }else if(userType.equals(UserType.PROJECT_OWNER)){
            List<Project> projects = projectService.getProjectsByOwner(user);
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }


    @ResponseBody
    @RolesAllowed("ADMIN")
    @PostMapping("/project/add")
    public void saveNewProject(@RequestBody ProjectDTO projectDTO) {
        System.out.println(projectDTO.getName() + " " + projectDTO.getAdminEmail() + " " + projectDTO.getOwnerEmail());
        User owner = userService.getUserByEmail(projectDTO.getOwnerEmail());
        User admin = userService.getUserByEmail(projectDTO.getAdminEmail());
        List<User> adminList = new ArrayList<>();
        adminList.add(admin);
        Project project = new Project(projectDTO.getName(), owner, adminList);
        projectService.saveProject(project);
    }

    @ResponseBody
    @RolesAllowed("ADMIN")
    @PostMapping("/project/add/admin")
    public void addNewAdminToProject(@RequestBody String email) {
        User admin = userService.getUserByEmail(email);
        Project project = projectService.find(projectService.getAll().get(0).getId());
        project.getAdmins().add(admin);
        projectService.saveProject(project);
    }
}
