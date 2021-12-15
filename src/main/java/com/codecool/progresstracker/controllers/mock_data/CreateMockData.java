package com.codecool.progresstracker.controllers.mock_data;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMockData {
    private UserService userService;
    private ProjectService projectService;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService){
        this.userService = userService;
        this.projectService = projectService;
    }

    public void spamMockData(){
        //String name, User owner, List<User> admins
        userService.createNewUser(UserType.PROJECT_OWNER,"owner1", "owner1Username", "valami");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner2", "owner1Username", "valam2");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner3", "owner1Username", "valam3");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner4", "owner1Username", "valam4");
        userService.createNewUser(UserType.PROJECT_OWNER,"owner5", "owner1Username", "valam5");

        userService.createNewUser(UserType.ADMIN,"admin1", "admin1Username", "pontez1");
        userService.createNewUser(UserType.ADMIN,"admin2", "admin2Username", "pontez2");
        userService.createNewUser(UserType.ADMIN,"admin3", "admin3Username", "pontez3");
        userService.createNewUser(UserType.ADMIN,"admin4", "admin4Username", "pontez4");
        userService.createNewUser(UserType.ADMIN,"admin5", "admin5Username", "pontez5");

        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));

        projectService.createNewProject("asadasd",userList.get(0), adminList);
        projectService.createNewProject("asadas2d",userList.get(0), adminList);
        projectService.createNewProject("asadas3d3",userList.get(0), adminList);
        projectService.createNewProject("asada444sd",userList.get(0), adminList);
        System.out.println("data done");
        //System.out.println(projectService.getAll().size());
    }

}
