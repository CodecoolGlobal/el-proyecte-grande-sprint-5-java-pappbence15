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
        userService.createNewUser(UserType.PROJECT_OWNER,"owner1", "owner1Username", "CodeBootSale@gmail.com", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner2", "owner1Username", "CodeBootSale@gmail.com", "valam2");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner3", "owner1Username", "CodeBootSale@gmail.com", "valam3");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner4", "owner1Username", "CodeBootSale@gmail.com", "valam4");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner5", "owner1Username", "CodeBootSale@gmail.com", "valam5");//5 project owners created and saved

        userService.createNewUser(UserType.ADMIN,"admin1", "admin1Username", "CodeBootSale@gmail.com", "pontez1");
        userService.createNewUser(UserType.ADMIN,"admin2", "admin2Username", "CodeBootSale@gmail.com", "pontez2");
        userService.createNewUser(UserType.ADMIN,"admin3", "admin3Username", "CodeBootSale@gmail.com", "pontez3");
        userService.createNewUser(UserType.ADMIN,"admin4", "admin4Username", "CodeBootSale@gmail.com", "pontez4");
        userService.createNewUser(UserType.ADMIN,"admin5", "admin5Username", "CodeBootSale@gmail.com", "pontez5");//5 admins created and saved

        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));//set logged in user

        projectService.createNewProject("asadasd",userList.get(0), adminList);
        projectService.createNewProject("asadas2d",userList.get(0), adminList);
        projectService.createNewProject("asadas3d3",userList.get(0), adminList);
        projectService.createNewProject("asada444sd",userList.get(0), adminList);//4 projects created and saved

        List<Project> projects = projectService.getAll();

        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 1", 0.65, false);
        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 2", 0.7,false);
        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 3", 0.3, true);

        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 4",0.01, true);
        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 5",0.8, false);
        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 6",0.96, true);





        goalService.createNewProjectGoal("goal1 of project1", Statuses.NEW, dateFormat.parse("2001-01-01"), projects.get(0));
        System.out.println(projects.get(0).getProjectGoals());

        goalService.createNewUserStoryGoal("userStoryGoal1 of project1's userStory1", Statuses.DONE, dateFormat.parse("2001-01-01"),
                projects.get(0).getUserStories().get(0)
        );
        System.out.println(projects.get(0).getUserStories().get(0).getUserStoryGoals());
    }
}
