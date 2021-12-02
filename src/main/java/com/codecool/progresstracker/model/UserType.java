package com.codecool.progresstracker.model;

import java.util.List;

public enum UserType {
    PRODUCT_OWNER("Product owner"),
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
