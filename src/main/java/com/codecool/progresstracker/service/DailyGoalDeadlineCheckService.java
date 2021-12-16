package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProjectDao;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.goal.ProjectGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailyGoalDeadlineCheckService {
    private final ProjectDao projectDao;
    private final NotificationService notificationService;
    SimpleDateFormat dateFormat;

    @Autowired
    public DailyGoalDeadlineCheckService(ProjectDao projectDao){
        this.projectDao = projectDao;
        this.notificationService = new NotificationService();
        this.dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
    }

    public final void sendOverDueNotifications() throws ParseException {
        List<Project> projectList = projectDao.getAll();
        String currentDateString = formatDateToString(LocalDate.now());//TODO fix naming and input error
        for (Project project : projectList) {
            for (ProjectGoal projectGoal : project.getProjectGoals()) {
                if (projectGoal.getDeadline().after(dateFormat.parse(currentDateString))){
                    //send overdue mail
                    System.out.println("found overdue ");
                    sendOverdueNotification(project, projectGoal);
                }
            }
        }
    }

    @Scheduled(cron = "* * * * * *", zone = "Europe/Budapest")
    public void scheduleFixedRateTask() {

    }

    private String formatDateToString(LocalDate date){
        String dateString = date.getYear() + "-";
        dateString += date.getMonthValue() + "-";
        dateString += date.getDayOfMonth();

        return dateString;
    }

    private String overdueProjectGoalTextGenerator(Project project, ProjectGoal projectGoal){
        String notificationText = "";

        notificationText = "Your project named :" + project.getName() + " has a project incomplete after it's deadline.\n";
        notificationText += "Goal " + projectGoal.getText() + " was due to finish today.\n";
        notificationText += "It's current status is " + projectGoal.getStatus().getStatusString() + ".\n";
        notificationText += "For further information pleas contact the project's admins: \n";
        notificationText += getProjectAdminsInformation(project)+"\n";
        notificationText += "Thank you for using our services!\n";
        notificationText += "If you encountered any problems in our systems please contact us at : CodeBootSale@gmail.com\n";

        return notificationText;
    }

    private void sendOverdueNotification(Project project, ProjectGoal projectGoal){
        String notificationMessage = overdueProjectGoalTextGenerator(project, projectGoal);
        NotificationService.sendMail(project.getOwner().getEmail(),"One of your project goals is overdue.", notificationMessage);



        System.out.println("mail sent");

        //make mail text
        //format mail text(??)
        //sendMail
    }

    private String getProjectAdminsInformation(Project project){
        StringBuilder allAdminsContactInformation = new StringBuilder();
        for (User admin : project.getAdmins()) {
            allAdminsContactInformation.append(admin.getName()).append(" at: ").append(admin.getEmail()).append("\n");
        }
        return allAdminsContactInformation.toString();
    }

    /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        goalService.createNewProjectGoal("goal1 of project1", Statuses.NEW, dateFormat.parse("2001-01-01"), projects.get(0));
        System.out.println(projects.get(0).getProjectGoals());

        goalService.createNewUserStoryGoal("userStoryGoal1 of project1's userStory1", Statuses.DONE, dateFormat.parse("2001-01-01"),
                projects.get(0).getUserStories().get(0)
        );
        System.out.println(projects.get(0).getUserStories().get(0).getUserStoryGoals());
   */

}
