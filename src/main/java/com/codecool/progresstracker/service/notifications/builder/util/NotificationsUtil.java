package com.codecool.progresstracker.service.notifications.builder.util;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.ProjectGoal;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class NotificationsUtil {
    public String overdueProjectGoalTextGeneratorForOwner(Project project, Goal projectGoal){
        String notificationText = "";

        notificationText = "Your project named: \"" + project.getName() + "\" has a project level goal incomplete after it's deadline.\n\n";
        notificationText += "The Goal named: \"" + projectGoal.getText() + "\"" +
                "was due to finish on :  " + formatDateToFancyString(projectGoal.getDeadline()) +".\n";
        notificationText += "It's currently set status is " + projectGoal.getStatus().getStatusString() + ".\n\n";
        notificationText += "For further information please contact the project's admins: \n";
        notificationText += getProjectAdminsInformation(project)+"\n";
        notificationText += "Thank you for using our services!\n";
        notificationText += "If you encountered any problems in our systems please contact us at : CodeBootSale@gmail.com\n";

        return notificationText;
    }

    public String overdueProjectGoalTextGeneratorForAdmin(Project project, Goal projectGoal){
        String notificationText = "";

        notificationText = "A project that you are an admin of: \"" + project.getName() + "\" has a project level goal incomplete after it's deadline.\n\n";
        notificationText += "The Goal named: \"" + projectGoal.getText() + "\"" +
                "was due to finish on :  " + formatDateToFancyString(projectGoal.getDeadline()) +".\n";
        notificationText += "It's currently set status is " + projectGoal.getStatus().getStatusString() + ".\n\n";

        notificationText += "We have notified the project's owner of the delay.\n";
        notificationText += "If the holdup is major please contact the owner at: " + project.getOwner().getEmail() + "\n";

        notificationText += "Thank you for using our services!\n";
        notificationText += "If you encountered any problems in our systems please contact us at : CodeBootSale@gmail.com\n";

        return notificationText;
    }

    private String getProjectAdminsInformation(Project project){
        StringBuilder allAdminsContactInformation = new StringBuilder();

        for (User admin : project.getAdmins()) {
            allAdminsContactInformation.append(admin.getName()).append(" at: ").append(admin.getEmail()).append("\n");
        }

        return allAdminsContactInformation.toString();
    }

    public String formatDateToString(LocalDate date){
        String dateString = date.getYear() + "-";
        dateString += date.getMonthValue() + "-";
        dateString += date.getDayOfMonth();

        return dateString;
    }

    private String formatDateToFancyString(Date date) {
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
