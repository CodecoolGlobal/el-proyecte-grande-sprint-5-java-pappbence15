package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.controllers.mock_data.CreateMockData;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.NotificationService;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import com.codecool.progresstracker.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    private final UserService userService;
    private final ProjectService projectService;//TODO TEST -> DELETE
    private final UserStoryService userStoryService;//test

    public LandingPageController(UserService userService, ProjectService projectService, UserStoryService userStoryService, UserStoryService userStoryService1) {
        NotificationService.sendMail();

        CreateMockData createMockData = new CreateMockData(userService, projectService, userStoryService);//TODO TEST -> DELETE
        createMockData.spamMockData();//TODO TEST -> DELETE

        this.userService = userService;
        this.projectService = projectService;//TODO TEST -> DELETE
        this.userStoryService = userStoryService1;//test
    }

    @GetMapping("/")
    public String welcomePage() {


        User user = userService.getLoggedInUser();

        if (user.getUserType().equals(UserType.ADMIN)){
            return "redirect:/admin/projects";
        } else if (user.getUserType().equals(UserType.PROJECT_OWNER)){
            return "redirect:/admin/projects";
        }

        return "welcome";
    }
}
