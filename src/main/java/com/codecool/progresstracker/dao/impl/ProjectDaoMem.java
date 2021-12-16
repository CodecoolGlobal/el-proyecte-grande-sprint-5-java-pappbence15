package com.codecool.progresstracker.dao.impl;

import com.codecool.progresstracker.dao.ProjectDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class ProjectDaoMem implements ProjectDao {
    private final List<Project> projects;

    public ProjectDaoMem() {
        this.projects = new ArrayList<>();
    }


    @Override
    public void add(Project project) {
        this.projects.add(project);
    }

    @Override
    public Project find(UUID id) throws NullPointerException {
        for (Project project : projects) {
            if (project.getId().equals(id)){
                return project;
            }
        }
        throw new NullPointerException("ProjectNotFound");
    }

    @Override
    public List<Project> getAll() {
        return projects;
    }

    @Override
    public List<Project> getProjectsByOwner(User user) {
        List<Project> projectsOfUser = new ArrayList<>();
        for (Project project : projects) {
            if (Objects.equals(project.getOwner(), user)){
                projectsOfUser.add(project);
            }
        }
        return projectsOfUser;
    }

    @Override
    public List<Project> getProjectsByAdmin(User user) {
        List<Project> projectsOfUser = new ArrayList<>();
        for (Project project : projects) {
            if (project.getAdmins().contains(user)){
                projectsOfUser.add(project);
            }
        }
        return projectsOfUser;
    }
}
