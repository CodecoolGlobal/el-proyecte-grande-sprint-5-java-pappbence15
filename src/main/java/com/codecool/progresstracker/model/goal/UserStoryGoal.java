package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;

import java.sql.Date;
import java.util.UUID;

public class UserStoryGoal extends Goal{

    private final UserStory parentStory;

    public UserStoryGoal(UUID id, String text, Statuses status, Date deadline, UserStory parentStory) {
        super(id, text, status, deadline, GoalType.USER_STORY_GOAL);
        this.parentStory = parentStory;
    }

}
