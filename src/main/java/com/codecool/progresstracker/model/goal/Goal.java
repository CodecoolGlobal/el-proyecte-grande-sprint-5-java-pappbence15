package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Statuses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public abstract class Goal {

    private final UUID id;
    private String text;
    private Statuses status;
    private Date deadline;
    private final GoalType goalType;
}
