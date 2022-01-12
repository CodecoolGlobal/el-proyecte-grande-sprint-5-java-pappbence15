package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.data_sample.UserStoryCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;

import com.codecool.progresstracker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository){
        this.userStoryRepository = userStoryRepository;
    }

    public void add(Project project, UserStory userStory){
        //TODO cascade if not gut
        this.userStoryRepository.save(userStory);
    }

    public UserStory find(UUID userStoryId){
        return userStoryRepository.getById(userStoryId);
    }

    public void toggleFavourite(UUID userStoryId, boolean isFavourite){
        userStoryRepository.updateFavourite(userStoryId, isFavourite);
    }

//    public void createNewUserStory(Project project, String name, double currentPercent, boolean isFavourite){
//        UserStoryCreator userStoryCreator = new UserStoryCreator(userStoryDao);
//
//        userStoryCreator.initialize(project, name, isFavourite, currentPercent);
//    }
}
