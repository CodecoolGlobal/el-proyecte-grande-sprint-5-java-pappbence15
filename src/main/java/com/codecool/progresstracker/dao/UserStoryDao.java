package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.UserStory;

import java.util.UUID;

public interface UserStoryDao {
    void add(UserStory userStory);
    UserStory find(UUID storyId);
}
