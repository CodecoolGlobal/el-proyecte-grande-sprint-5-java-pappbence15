package com.codecool.progresstracker.service.notifications;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.service.notifications.builder.DailyGoalDeadlineCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@EnableScheduling
public class RepeatedMessageSender {
    private final ProjectDao projectDao;

    @Autowired
    public RepeatedMessageSender(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    @Scheduled(cron = "0 0 8 * * *")//repeat every day at 0 //TODO fix: scheduled task repeats when first called, search for fixing it
    public void scheduleFixedRateTask() throws ParseException {
        DailyGoalDeadlineCheckService dailyNotificationService = new DailyGoalDeadlineCheckService(projectDao);
        dailyNotificationService.sendOverDueNotifications();
        System.out.println("scheduled emails sent");
    }
}
