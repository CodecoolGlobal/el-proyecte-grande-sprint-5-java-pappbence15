package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProjectService;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Controller
public class SketchyViewController {
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public SketchyViewController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/admin/project/{projectId}")
    public String adminProjectPage(Model model, @PathVariable UUID projectId) throws Exception {
        Project project = projectService.getById(projectId);

        User user = userService.getLoggedInUser();

        model.addAttribute("user", user);
        UserType userType = user.getUserType();

        model.addAttribute("project", project);
        model.addAttribute("progress", Math.round(project.getPercentage()*100) + " %");

        if (userType == UserType.ADMIN && project.getAdmins().contains(user)) {
            return "admin_project_view";
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/owner/project/{projectId}")
    public String ownerProjectPage(Model model, @PathVariable UUID projectId) throws Exception {
        Project project = projectService.getById(projectId);

        User user = userService.getLoggedInUser();

        model.addAttribute("user", user);
        UserType userType = user.getUserType();

        model.addAttribute("project", project);

        if (userType == UserType.PROJECT_OWNER && project.getOwner().equals(user)){
            return "owner_project_view";
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
