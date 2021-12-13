package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;

import java.util.List;
import java.util.UUID;

public interface ProductDao {

    void add(Project product);
    Project find(UUID id) throws Exception;

    List<Project> getAll();
    List<Project> getProductsByOwner(User user);
    List<Project> getProductsByAdmin(User user);
}
