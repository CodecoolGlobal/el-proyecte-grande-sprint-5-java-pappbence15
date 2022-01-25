package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.model.*;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateMockData {
    private final UserService userService;
    private final ProjectService projectService;
    private final UserStoryService userStoryService;

    private final SimpleDateFormat dateFormat;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService, UserStoryService userStoryService){
        this.userService = userService;
        this.projectService = projectService;
        this.userStoryService = userStoryService;


        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void spamMockData(){

        User user = new User(UserType.PROJECT_OWNER,"John Smith", "John", "john@gmail.com","John123", new UserSettings());
        userService.createNewUser(user);
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Ruth Gilbert", "Ruth", "ruth@gmail.com", "Ruth123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Gillian Medina", "Gillian", "gillian@gmail.com", "Gillian123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Travis Hart", "Travis", "travis@gmail.com", "Travis123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Sybil Bush", "Sybil", "sybil@gmail.com", "Sybil123", new UserSettings()));

        userService.createNewUser(new User(UserType.ADMIN,"Anna GrossBerg, ", "Anna", "anna@gmail.com", "Anna123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Pat Lawrence", "Pat", "pat@gmail.com", "Pat123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Wren Hodgson", "Wren", "wren@gmail.com", "Wren132", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Darren Fraley", "Darren", "darren@gmail.com", "Darren123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Bonnie Briggs", "Bonnie", "bonnie@gmail.com", "Bonnie123", new UserSettings()));



        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));//set logged in user

        projectService.createNewProject(new Project("Build My House", userList.get(0), adminList));
        projectService.createNewProject(new Project("Garden renovation", userList.get(0), adminList));
        List<Project> projects = projectService.getAll();

//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("House base", 0.65, true));
//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Painting", 0.7, false));
//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Furnishing", 0.3, false));
//
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("Get rid of old plants", 0.62, false));
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("Irrigation system", 0.3, true));
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("New plants", 0.1, true));


//        goalService.createNewProjectGoal("A csempe megrendelése", Statuses.IN_PROGRESS, dateFormat.parse("2021-12-15"), projects.get(0));
//
//        goalService.createNewUserStoryGoal("A csempe felhelyezése", Statuses.NEW, dateFormat.parse("2021-12-15"),
//                projects.get(0).getUserStories().get(0)
//        );
    }
}
