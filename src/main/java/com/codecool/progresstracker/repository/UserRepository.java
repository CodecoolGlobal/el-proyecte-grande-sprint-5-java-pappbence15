package com.codecool.progresstracker.repository;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserSettings;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    User getUserById(UUID userId);

    @Query("select u from User u")
    List<User> getAll();

    @Query("select u.userSettings from User u where u.id = :userId")
    UserSettings getUserSettings(@Param("userId")UUID userId);

    @Modifying
    @Query("update User u set u.userSettings = :newSettings where u.id = :userId")
    void updateUserSettings(@Param("userId")UUID userId,
                            @Param("newSettings")UserSettings newSettings);
}
