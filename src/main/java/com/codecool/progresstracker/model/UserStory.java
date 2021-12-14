package com.codecool.progresstracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserStory {
    private final UUID id = UUID.randomUUID();
    private String name;
    private int MAX_PROGRESS;
    private int currentProgress;
    private double currentPercent;
    private boolean isFavourite;

    public void setCurrentProgress(int currentPercentage) {
        this.currentProgress = Math.round(this.MAX_PROGRESS / currentPercentage * 100);
    }

    public boolean isStoryComplete(){
        return this.MAX_PROGRESS == currentProgress;
    }

    public void makeFavourite(){
        this.isFavourite = true;
    }

}