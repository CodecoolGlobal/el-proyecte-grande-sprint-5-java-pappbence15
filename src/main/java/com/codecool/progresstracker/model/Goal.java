package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Goal {

    private final UUID id;
    private String text;
    private Statuses status;
    private Date deadline;
    //project/userStory parent, id/parent as field??
}
