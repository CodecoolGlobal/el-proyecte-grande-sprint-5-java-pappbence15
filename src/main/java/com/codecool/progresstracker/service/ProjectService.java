package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.data_sample.ProjectCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project find(UUID id) throws Exception {
        return projectDao.find(id);
    }

    public List<Project> getProjectsByAdmin(User admin){
        return projectDao.getProjectsByAdmin(admin);
    }

    public void createNewProject(String name, User owner, List<User> admins){
        ProjectCreator projectCreator = new ProjectCreator(projectDao);

        projectCreator.initialize(
                name,
                owner,
                admins
        );
    }

    public void updateUserStory(boolean isFavourite, int currentPercent, UUID userStoryId, UUID projectId) throws NullPointerException {
        try {
            Project project = projectDao.find(projectId);

            UserStory userStory = project.findStory(userStoryId);

            userStory.setFavourite(isFavourite);
            userStory.setCurrentPercent(currentPercent);

        }catch(NullPointerException notFoundElement){
            throw new NullPointerException("Item not found during userStory update");
        }
    }


    public List<Project> getProjectsByOwner(User user) {
        return projectDao.getProjectsByOwner(user);
    }

    public List<Project> getAll(){
        return projectDao.getAll();
    }


}
