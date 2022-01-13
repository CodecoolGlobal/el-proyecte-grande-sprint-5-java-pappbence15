package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Statuses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Goal {
    @Id
    @GeneratedValue
    private UUID id;
    private String text;
    private Statuses status;
    private Date deadline;
    private GoalType goalType;
}
