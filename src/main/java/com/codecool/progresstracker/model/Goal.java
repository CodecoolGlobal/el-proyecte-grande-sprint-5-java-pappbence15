package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Goal {

    private UUID id;
    private String text;
    private Statuses status;
    private Date deadline;
    //project/userStory parent, id/parent as field??
}
