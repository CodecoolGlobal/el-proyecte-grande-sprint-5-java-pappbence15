package com.codecool.progresstracker.repository;

import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.model.goal.Goal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserStoryRepository extends CrudRepository<UserStory, UUID> {

    @Modifying
    @Query("update UserStory us " +
            "set us.currentPercent = :currentPercent," +
            " us.isFavourite = :isFavorite," +
            " us.name = :name," +
            " us.userStoryGoals = :userStoryGoals" +
            " where us.id = :userStoryId")
    void updateUserStory(@Param("userStoryId") UUID userStoryId,
                         @Param("currentPercent") double currentPercent,
                         @Param("isFavorite") boolean isFavorite,
                         @Param("name") String name,
                         @Param("userStoryGoals")List<Goal> userStoryGoals);
}
