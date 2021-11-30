package com.codecool.progresstracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private List<UserStory> userStories;
    private final User owner;
    private final List<User> admins;

    public Product(UUID id, String name, User owner, List<User> admins) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.admins = admins;
        userStories = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void addNewUserStory(UserStory userStory){
        userStories.add(userStory);
    }

    public User getOwner() {
        return owner;
    }

    public List<User> getAdmins() {
        return admins;
    }
}