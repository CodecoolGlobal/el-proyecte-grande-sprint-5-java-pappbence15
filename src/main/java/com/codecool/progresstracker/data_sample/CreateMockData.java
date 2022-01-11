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
        spamMockData();
    }

    public void spamMockData() throws ParseException {
        //Crippled the email sending service with setting mock data emails to CodeBootSale@gmail.com, thanks
/*

        userService.createNewUser(UserType.PROJECT_OWNER,"Kis Ferenc", "Feri_vagyok_a", "CodeBootSale@gmail.com","valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"Récsán Gabi", "gaborrecsan1", "CodeBootSale@gmail.com", "valam2");
        userService.createNewUser(UserType.PROJECT_OWNER,"Simon Peti", "P-dog", "CodeBootSale@gmail.com", "valam3");
        userService.createNewUser(UserType.PROJECT_OWNER,"Urbán Urbán", "Urbán", "CodeBootSale@gmail.com", "valam4");
        userService.createNewUser(UserType.PROJECT_OWNER,"Ecneb Károly", "Karcsi bácsi", "CodeBootSale@gmail.com", "valam5");//5 project owners created and saved

        userService.createNewUser(UserType.ADMIN,"TheBackEndGuy, ", "admin1Username", "CodeBootSale@gmail.com", "pontez1");
        userService.createNewUser(UserType.ADMIN,"P-dog", "admin2Username", "CodeBootSale@gmail.com", "pontez2");
        userService.createNewUser(UserType.ADMIN,"Lukács Csilla", "admin3Username", "CodeBootSale@gmail.com", "pontez3");
        userService.createNewUser(UserType.ADMIN,"Szabó Bence", "admin4Username", "CodeBootSale@gmail.com", "pontez4");
        userService.createNewUser(UserType.ADMIN,"Benec", "admin5Username", "CodeBootSale@gmail.com", "pontez5");//5 admins created and saved

*/

//        List<User> userList = userService.getAll();
//        List<User> adminList = new ArrayList<>();
//        adminList.add(userList.get(5));
//        adminList.add(userList.get(6));
//
//        userService.setLoggedInUser(userList.get(5));//set logged in user

//        projectService.createNewProject("Neres kávéház",userList.get(0), adminList);
//        projectService.createNewProject("Antal-film",userList.get(0), adminList);
//        projectService.createNewProject("Journey refactor",userList.get(0), adminList);
//        projectService.createNewProject("Codewars 5kyu",userList.get(0), adminList);//4 projects created and saved

//        List<Project> projects = projectService.getAll();

//        userStoryService.createNewUserStory(projects.get(0),"Csempézés", 0.65, true);
//        userStoryService.createNewUserStory(projects.get(0),"Falfestés", 0.7,false);
//        userStoryService.createNewUserStory(projects.get(0),"Lakkozás", 0.3, false);
//
//        userStoryService.createNewUserStory(projects.get(1),"Pénzgyűjtés",0.01, true);
//        userStoryService.createNewUserStory(projects.get(1),"Final script",0.8, false);
//        userStoryService.createNewUserStory(projects.get(1),"Ruha design",0.96, true);

        //thanks for deleting mock data for goals :)
        //I consider myself lucky because I refactored most of the dead code at 11:00PM
        //So I had the privilege to see my beauty of an automatic email sender crippled without data
        //oh and thanks again

//        goalService.createNewProjectGoal("A csempe megrendelése", Statuses.IN_PROGRESS, dateFormat.parse("2021-12-15"), projects.get(0));
//
//        goalService.createNewUserStoryGoal("A csempe felhelyezése", Statuses.NEW, dateFormat.parse("2021-12-15"),
//                projects.get(0).getUserStories().get(0)
//        );
    }
}
