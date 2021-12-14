package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectDao projectDao;
    private final UserDao userDao;
    private final UserService userService;
    public final UUID TEST_PROJECT_ID;

    @Autowired
    public ProjectService(ProjectDao projectDao, UserDao userDao, UserService userService) {
        this.projectDao = projectDao;
        this.userDao = userDao;
        this.userService = userService;
        this.TEST_PROJECT_ID = addAProjectWithTestUserAsAdmin();
    }


    public UUID addAProjectWithTestUserAsAdmin(){
        User user = userService.getTestAdmin();
        List<User> adminList = new ArrayList<>();
        adminList.add(user);
        Project project = new Project("Building a house on Firefly Lane", null, adminList);
        UserStory userStory = new UserStory("paint the walls", 4);
        UserStory userStory2 = new UserStory("build the roof", 1);
        project.addNewUserStory(userStory);
        project.addNewUserStory(userStory2);
        userStory2.makeFavourite();
        projectDao.add(project);
        return project.getId();
    }

    public Project getById(UUID id) throws Exception {
        return projectDao.find(id);
    }

    public List<Project> getProjectsByAdmin(User admin){
        return projectDao.getProjectsByAdmin(admin);
    }

    public void updateUserStory(UserStory newUserStory, UUID userStoryId, UUID projectId) throws Exception {
        Project pr = projectDao.find(projectId);
        List<UserStory> userStories = pr.getUserStories();
        UserStory us;
        for (UserStory userStory: userStories) {
            if(userStory.getId().equals(userStoryId)){
                us = userStory;
            }
        }
        us = newUserStory;
    }

    public void addNewUserStory(UserStory userStory, Project project) throws Exception {
        projectDao.find(project.getId()).addNewUserStory(userStory);
    }

    public List<Project> getProjectsByOwner(User user) {
        return projectDao.getProjectsByOwner(user);
    }
}
