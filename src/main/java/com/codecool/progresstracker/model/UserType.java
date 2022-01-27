package com.codecool.progresstracker.model;

public enum UserType {
    PROJECT_OWNER("owner"),
    ADMIN("admin"),
    SUPER_USER("SuperUser");

    private final String fancyUserType;

    public String getFancyUserType(){
        return this.fancyUserType;
    }

    UserType(String fancyUserType) {
        this.fancyUserType = fancyUserType;
    }
}
