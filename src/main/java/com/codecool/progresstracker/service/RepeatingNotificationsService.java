package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.service.notifications.GoalDeadlineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@EnableScheduling
public class RepeatingNotificationsService {
    private final GoalDeadlineHandler goalDeadlineHandler;

    @Autowired
    public RepeatingNotificationsService(ProjectDao projectDao){
        this.goalDeadlineHandler = new GoalDeadlineHandler(projectDao);
    }

    /**
     * Scan for overdue Goals and send automated emails
     * Repeats every day at 08:00:00
     */
    @Scheduled(cron = "0 0 8 * * *", zone ="Europe/Budapest")
    public void scheduleOverdueGoalHandling() throws ParseException {
        goalDeadlineHandler.sendOverDueNotifications();
    }
}
