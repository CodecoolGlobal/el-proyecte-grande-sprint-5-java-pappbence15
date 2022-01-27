package com.codecool.progresstracker.security;

public enum ApplicationUserRole {
    ADMIN("ADMIN"),
    OWNER("OWNER");

    private final String user;

    ApplicationUserRole(String user) {
        this.user = user;
    }
}
