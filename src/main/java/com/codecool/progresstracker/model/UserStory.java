package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserStory {
    private final UUID id;
    private final String name;
    private final int MAX_PROGRESS;
    private int currentProgress;
    private double currentPercent;
    private boolean isFavourite;

    public void setCurrentPercent(int currentPercent) {
        this.currentPercent = currentPercent;
        this.currentProgress = Math.round(this.MAX_PROGRESS / currentPercent * 100);
    }

    public boolean isStoryComplete(){
        return this.MAX_PROGRESS == currentProgress;
    }
}