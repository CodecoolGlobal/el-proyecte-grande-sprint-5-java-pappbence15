package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
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
    private final UserStoryService userStoryService;
    private final GoalService goalService;

    private final SimpleDateFormat dateFormat;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService, UserStoryService userStoryService, GoalService goalService) throws ParseException {
        this.userService = userService;
        this.projectService = projectService;
        this.userStoryService = userStoryService;
        this.goalService = goalService;

        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        spamMockData();//TODO TEST -> DELETE;
    }

    public void spamMockData() throws ParseException {
        //String name, User owner, List<User> admins
        userService.createNewUser(UserType.PROJECT_OWNER,"Kis Ferenc", "Feri_vagyok_a", "valami", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"Récsán Gabi", "gaborrecsan1", "valam2", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"Simon Peti", "P-dog", "valam3", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"Urbán Urbán", "Urbán", "valam4", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"Ecneb Károly", "Karcsi bácsi", "valam5", "valami");//5 project owners created and saved

        userService.createNewUser(UserType.ADMIN,"Mr. X, ", "admin1Username", "pontez1", "valami");
        userService.createNewUser(UserType.ADMIN,"P-dog", "admin2Username", "pontez2", "valami");
        userService.createNewUser(UserType.ADMIN,"Lukács Csilla", "admin3Username", "pontez3", "valami");
        userService.createNewUser(UserType.ADMIN,"Szabó Bence", "admin4Username", "pontez4", "valami");
        userService.createNewUser(UserType.ADMIN,"Benec", "admin5Username", "pontez5", "valami");//5 admins created and saved

        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));//set logged in user

        projectService.createNewProject("Neres kávéház",userList.get(0), adminList);
        projectService.createNewProject("Antal-film",userList.get(0), adminList);
        projectService.createNewProject("Journey refactor",userList.get(0), adminList);
        projectService.createNewProject("Codewars 5kyu",userList.get(0), adminList);//4 projects created and saved

        List<Project> projects = projectService.getAll();

        userStoryService.createNewUserStory(projects.get(0),"Csempézés", 0.65, true);
        userStoryService.createNewUserStory(projects.get(0),"Falfestés", 0.7,false);
        userStoryService.createNewUserStory(projects.get(0),"Lakkozás", 0.3, false);

        userStoryService.createNewUserStory(projects.get(1),"Pénzgyűjtés",0.01, true);
        userStoryService.createNewUserStory(projects.get(1),"Final script",0.8, false);
        userStoryService.createNewUserStory(projects.get(1),"Ruha design",0.96, true);


    }
}
