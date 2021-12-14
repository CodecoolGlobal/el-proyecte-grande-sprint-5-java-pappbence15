package com.codecool.progresstracker.model;

public enum Statuses {
    NEW("New"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
    LATE("Late"),
    ERROR("Error");

    private final String statusString;
    Statuses(String statusString){
        this.statusString = statusString;
    }

    public String getStatusString() {
        return statusString;
    }
}
