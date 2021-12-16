package com.codecool.progresstracker.model;

public enum UserType {
    PROJECT_OWNER("Project owner"),
    ADMIN("Admin"),
    SUPER_USER("Super user");


    private String fancyUserType;

    public String getFancyUserType(){
        return this.fancyUserType;
    }

    UserType(String fancyUserType) {
        this.fancyUserType = fancyUserType;
    }
}
