package com.codecool.progresstracker.service;

import com.codecool.progresstracker.data_sample.ProjectCreator;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;

import com.codecool.progresstracker.repository.ProjectRepository;
import com.codecool.progresstracker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserStoryRepository userStoryRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          UserStoryRepository userStoryRepository)
    {
        this.projectRepository = projectRepository;
        this.userStoryRepository = userStoryRepository;
    }

    public Project find(UUID id) {
        return projectRepository.getById(id);
    }

    public List<Project> getProjectsByAdmin(User admin){
        return projectRepository.getAllByAdmins(admin);
    }

    public void createNewProject(Project newProject){
        projectRepository.save(newProject);
    }

    public void updateUserStory(UserStory newUserStory, UUID userStoryId) throws NullPointerException {
        try {
            userStoryRepository.updateUserStory(
                    userStoryId,
                    newUserStory.getCurrentPercent(),
                    newUserStory.isFavourite(),
                    newUserStory.getName(),
                    newUserStory.getUserStoryGoals()
            );

        }catch(NullPointerException notFoundElement){
            throw new NullPointerException("Item not found during userStory update");
        }
    }


    public List<Project> getProjectsByOwner(User user) {
        return projectRepository.getAllByOwner(user);
    }

    public List<Project> getAll(){
        return projectRepository.getAll();
    }

    public void saveNewProject(Project project) {
        projectRepository.save(project);
    }
}
