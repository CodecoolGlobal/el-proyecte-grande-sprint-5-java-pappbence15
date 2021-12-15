package com.codecool.progresstracker.dao.impl;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserStoryDaoMem implements UserStoryDao {
    private final List<UserStory> userStories;

    public UserStoryDaoMem() {
        this.userStories = new ArrayList<UserStory>();
    }

    @Override
    public void add(UserStory userStory) {
        this.userStories.add(userStory);
    }
}
