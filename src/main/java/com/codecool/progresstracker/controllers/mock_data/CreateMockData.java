package com.codecool.progresstracker.controllers.mock_data;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import com.codecool.progresstracker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMockData {
    private final UserService userService;
    private final ProjectService projectService;
    private final UserStoryService userStoryService;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService, UserStoryService userStoryService){
        this.userService = userService;
        this.projectService = projectService;
        this.userStoryService = userStoryService;
    }

    public void spamMockData(){
        //String name, User owner, List<User> admins
        userService.createNewUser(UserType.PROJECT_OWNER,"owner1", "owner1Username", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner2", "owner1Username", "valam2");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner3", "owner1Username", "valam3");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner4", "owner1Username", "valam4");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner5", "owner1Username", "valam5");//5 project owners created and saved

        userService.createNewUser(UserType.ADMIN,"admin1", "admin1Username", "pontez1");
        userService.createNewUser(UserType.ADMIN,"admin2", "admin2Username", "pontez2");
        userService.createNewUser(UserType.ADMIN,"admin3", "admin3Username", "pontez3");
        userService.createNewUser(UserType.ADMIN,"admin4", "admin4Username", "pontez4");
        userService.createNewUser(UserType.ADMIN,"admin5", "admin5Username", "pontez5");//5 admins created and saved

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

        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 1",75, false);
        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 2",80, false);
        userStoryService.createNewUserStory(projects.get(0),"(of 0) teszt story 3",96, true);

        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 4",1, true);
        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 5",300, false);
        userStoryService.createNewUserStory(projects.get(1),"(of 1) teszt story 6",96, true);
    }
}
