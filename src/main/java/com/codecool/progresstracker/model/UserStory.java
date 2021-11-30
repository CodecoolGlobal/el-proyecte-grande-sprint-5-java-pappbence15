package com.codecool.progresstracker.model;

import java.util.UUID;

public class UserStory {
    private final UUID id;
    private final String name;
    private final int MAX_PROGRESS;
    private int currentProgress;
    private boolean isFavourite;

    public UserStory(String name, int max_progress) {
        this.id = UUID.randomUUID();
        this.currentProgress = 0;
        this.name = name;
        MAX_PROGRESS = max_progress;
        this.isFavourite = false;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMAX_PROGRESS() {
        return MAX_PROGRESS;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int currentPercentage) {
        this.currentProgress = Math.round(this.MAX_PROGRESS / currentPercentage * 100);
    }

    public boolean isStoryComplete(){
        return this.MAX_PROGRESS == currentProgress;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void makeFavourite(){
        this.isFavourite = true;
    }
}