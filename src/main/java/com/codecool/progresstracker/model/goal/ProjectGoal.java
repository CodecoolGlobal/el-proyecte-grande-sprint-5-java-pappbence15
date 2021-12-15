package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.Statuses;

import java.sql.Date;
import java.util.UUID;

public class ProjectGoal extends Goal {
    private final Project parentProject;

    public ProjectGoal(UUID id, String text, Statuses status, Date deadline, Project parentProject) {
        super(id, text, status, deadline, GoalType.PROJECT_GOAL);
        this.parentProject = parentProject;
    }
}
