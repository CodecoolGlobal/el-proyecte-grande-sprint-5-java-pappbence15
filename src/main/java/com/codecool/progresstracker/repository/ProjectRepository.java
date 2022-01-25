package com.codecool.progresstracker.repository;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    Project getById(UUID id);

    List<Project> getAllByAdmins(User admin);

    List<Project> getAllByOwner(User owner);

    @Query("select p from Project p")
    List<Project> getAll();
}
