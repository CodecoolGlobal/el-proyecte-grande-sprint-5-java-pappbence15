package com.codecool.progresstracker.controllers.data_sample;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProjectCreator {

    private ProjectDao projectDao;

    @Autowired
    public ProjectCreator(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    public void initialize(String name, User owner, List<User> admins) {
        Project project = new Project();

        project.setId(UUID.randomUUID());
        project.setName(name);
        project.setOwner(owner);
        project.setAdmins(admins);
        project.setUserStories(new ArrayList<>());

        projectDao.add(project);
    }
}
