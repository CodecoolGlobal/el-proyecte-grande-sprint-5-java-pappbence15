package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Statuses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Goal {
    @Id
    private UUID id;
    private String text;
    private Statuses status;
    private Date deadline;
    private GoalType goalType;
}
