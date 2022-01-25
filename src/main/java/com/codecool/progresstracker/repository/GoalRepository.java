package com.codecool.progresstracker.repository;

import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.model.goal.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

    Goal getById(UUID id);

    @Modifying
    @Query("update Goal g set g.deadline = :deadline, " +
            "g.goalType = :goalType, " +
            "g.status = :status, " +
            "g.text =:text " +
            "where g.id = :goalId")
    void updateGoal(@Param("deadline") Date deadline,
                    @Param("goalType")GoalType goalType,
                    @Param("status") Statuses status,
                    @Param("text") String text,
                    @Param("goalId") UUID goalId
    );
}
