package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;

import java.util.List;
import java.util.UUID;

public interface ProjectDao {

    void add(Project project);
    Project find(UUID id) throws NullPointerException;

    List<Project> getAll();
    List<Project> getProjectsByOwner(User user);
    List<Project> getProjectsByAdmin(User user);
}
