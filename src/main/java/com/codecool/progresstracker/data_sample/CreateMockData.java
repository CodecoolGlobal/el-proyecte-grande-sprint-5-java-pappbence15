package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.model.*;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMockData {
    private final UserService userService;
    private final ProjectService projectService;


    private final SimpleDateFormat dateFormat;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService){
        this.userService = userService;
        this.projectService = projectService;


        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void spamMockData(){


        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Kis Ferenc", "Feri_vagyok_a", "CodeBootSale@gmail.com","valami", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Récsán Gabi", "gaborrecsan1", "CodeBootSale@gmail.com", "valam2", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Simon Peti", "P-dog", "CodeBootSale@gmail.com", "valam3", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Urbán Urbán", "Urbán", "CodeBootSale@gmail.com", "valam4", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Ecneb Károly", "Karcsi bácsi", "CodeBootSale@gmail.com", "valam5", new UserSettings()));//5 project owners created and saved

        userService.createNewUser(new User(UserType.ADMIN,"TheBackEndGuy, ", "admin1Username", "CodeBootSale@gmail.com", "pontez1", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"P-dog", "admin2Username", "CodeBootSale@gmail.com", "pontez2", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Lukács Csilla", "admin3Username", "CodeBootSale@gmail.com", "pontez3", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Szabó Bence", "admin4Username", "CodeBootSale@gmail.com", "pontez4", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Benec", "admin5Username", "CodeBootSale@gmail.com", "pontez5", new UserSettings()));//5 admins created and saved



        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));//set logged in user

        projectService.createNewProject(new Project("Neres kávéház", userList.get(0), adminList));
        projectService.createNewProject(new Project("Antal-film", userList.get(0), adminList));
        projectService.createNewProject(new Project("Journey refactor", userList.get(0), adminList));
        projectService.createNewProject(new Project("Codewars 5kyu", userList.get(0), adminList));//4 projects created and saved

        List<Project> projects = projectService.getAll();

//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Csempézés", 0.65, true, new ArrayList<Goal>()));
//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Falfestés", 0.7, true, new ArrayList<Goal>()));
//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Lakkozás", 0.3, true, new ArrayList<Goal>()));
//
//        userStoryService.addNewUserStory(projects.get(1),"Pénzgyűjtés",0.01, true);
//        userStoryService.addNewUserStory(projects.get(1),"Final script",0.8, false);
//        userStoryService.createNewUserStory(projects.get(1),"Ruha design",0.96, true);


//        goalService.createNewProjectGoal("A csempe megrendelése", Statuses.IN_PROGRESS, dateFormat.parse("2021-12-15"), projects.get(0));
//
//        goalService.createNewUserStoryGoal("A csempe felhelyezése", Statuses.NEW, dateFormat.parse("2021-12-15"),
//                projects.get(0).getUserStories().get(0)
//        );
    }
}
