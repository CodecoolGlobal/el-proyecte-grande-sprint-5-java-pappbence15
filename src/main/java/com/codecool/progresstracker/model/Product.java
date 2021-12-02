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

    public Product(String name, User owner, List<User> admins) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.admins = admins;
        this.userStories = new ArrayList<>();
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

    public double getPercentage(){
        double totalStoryPoints = userStories.stream()
                .map(UserStory::getMAX_PROGRESS)
                .reduce(0, Integer::sum);
        double completed = userStories.stream()
                .map(story -> story.getMAX_PROGRESS()*story.getCurrentPercent())
                .reduce(0.0, Double::sum);
        return completed / totalStoryPoints;
    }
}