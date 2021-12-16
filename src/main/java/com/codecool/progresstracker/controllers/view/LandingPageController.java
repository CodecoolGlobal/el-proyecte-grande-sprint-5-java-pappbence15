package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.data_sample.CreateMockData;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;

@Controller
public class LandingPageController {
    private final UserService userService;
    private final ProjectService projectService;//TODO TEST -> DELETE
    private final UserStoryService userStoryService;//test
    private final GoalService goalService;

    public LandingPageController(UserService userService,
                                 ProjectService projectService,
                                 UserStoryService userStoryService,
                                 UserStoryService userStoryService1,
                                 GoalService goalService) throws ParseException {
        NotificationService.sendMail();

        CreateMockData createMockData = new CreateMockData(userService, projectService, userStoryService, goalService);//TODO TEST -> DELETE
        createMockData.spamMockData();//TODO TEST -> DELETE

        this.userService = userService;
        this.projectService = projectService;//TODO TEST -> DELETE
        this.userStoryService = userStoryService1;//test
        this.goalService = goalService;
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
