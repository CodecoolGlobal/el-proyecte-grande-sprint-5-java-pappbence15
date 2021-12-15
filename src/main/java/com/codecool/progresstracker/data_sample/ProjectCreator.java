package com.codecool.progresstracker.data_sample;

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

    private final ProjectDao projectDao;

    @Autowired
    public ProjectCreator(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    public void initialize(String name, User owner, List<User> admins) {
        Project project = new Project(
                UUID.randomUUID(),
                name,
                new ArrayList<>(),
                owner,
                admins
        );

        projectDao.add(project);
    }
}
