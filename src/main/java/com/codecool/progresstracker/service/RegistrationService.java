package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.data_sample.UserCreator;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;

import com.codecool.progresstracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public void registerUser(User newUser){
        userRepository.save(newUser);
    }

    public UserType stringToUserTypeConverter (String userType){
        switch(userType){
            case "ADMIN":
                return UserType.ADMIN;
            case "SUPER_USER":
                return UserType.SUPER_USER;
            default:
                return UserType.PROJECT_OWNER;
        }
    }
}
