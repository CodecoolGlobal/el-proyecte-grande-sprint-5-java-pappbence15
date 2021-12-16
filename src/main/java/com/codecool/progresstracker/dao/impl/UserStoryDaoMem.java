package com.codecool.progresstracker.dao.impl;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserStoryDaoMem implements UserStoryDao {
    private final List<UserStory> userStories;

    @Autowired
    public UserStoryDaoMem() {
        this.userStories = new ArrayList<>();
    }

    @Override
    public void add(UserStory userStory) {
        this.userStories.add(userStory);
    }

    @Override
    public UserStory find(UUID storyId) {
        return userStories.stream().filter(s-> Objects.equals(s.getId(), storyId)).collect(Collectors.toList()).get(0);
    }
}
