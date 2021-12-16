package com.codecool.progresstracker.service.notifications;

import com.codecool.progresstracker.dao.ProjectDao;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.goal.ProjectGoal;

import com.codecool.progresstracker.service.notifications.builder.NotificationService;
import com.codecool.progresstracker.service.notifications.builder.util.NotificationsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class GoalDeadlineHandler {
    private final ProjectDao projectDao;
    private final NotificationService notificationService;
    private final SimpleDateFormat dateFormat;
    private final NotificationsUtil util;

    @Autowired
    public GoalDeadlineHandler(ProjectDao projectDao){
        this.projectDao = projectDao;
        this.notificationService = new NotificationService();
        this.dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
        this.util = new NotificationsUtil();
    }

    public final void sendOverDueNotifications() throws ParseException {
        List<Project> projectList = projectDao.getAll();
        String currentDateString = util.formatDateToString(LocalDate.now());
        Date currentDate = dateFormat.parse(currentDateString);
        for (Project project : projectList) {
            for (ProjectGoal projectGoal : project.getProjectGoals()) {
                if (currentDate.after(projectGoal.getDeadline())){
                    notificationHandler(project, projectGoal);
                }
            }
        }
    }

    private void notificationHandler(Project project, ProjectGoal projectGoal){
        String messageForOwner = util.overdueProjectGoalTextGeneratorForOwner(project, projectGoal);
        sendOverdueNotificationToOwner(project.getOwner().getEmail(), project.getName(),messageForOwner);

        String messageForAdmins = util.overdueProjectGoalTextGeneratorForAdmin(project, projectGoal);
        sendOverdueNotificationToAdmins(project.getAdmins(), project.getName(), messageForAdmins);
    }

    private void sendOverdueNotificationToOwner(String address, String projectName, String message){
        NotificationService.sendMail(address,"One of " + projectName+ "'s project goals is overdue.", message);
    }

    public void sendOverdueNotificationToAdmins(List<User> admins, String projectName, String message){
        for (User admin : admins) {
            NotificationService.sendMail(admin.getEmail(),"One of " + projectName+ "'s project level goals task is overdue.", message);
        }
    }


}
