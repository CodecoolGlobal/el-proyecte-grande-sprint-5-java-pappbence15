package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProductDao;
import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductDao productDao;
    private final UserDao userDao;
    private final UserService userService;
    public final UUID TEST_PROJECT_ID;

    @Autowired
    public ProductService(ProductDao productDao, UserDao userDao, UserService userService) {
        this.productDao = productDao;
        this.userDao = userDao;
        this.userService = userService;
        this.TEST_PROJECT_ID = addAProductWithTestUserAsAdmin();
    }


    public UUID addAProductWithTestUserAsAdmin(){
        User user = userService.getTestAdmin();
        List<User> adminList = new ArrayList<>();
        adminList.add(user);
        Project product = new Project("Building a house on Firefly Lane", null, adminList);
        UserStory userStory = new UserStory("paint the walls", 4);
        UserStory userStory2 = new UserStory("build the roof", 1);
        product.addNewUserStory(userStory);
        product.addNewUserStory(userStory2);
        userStory2.makeFavourite();
        productDao.add(product);
        return product.getId();
    }

    public Project getById(UUID id) throws Exception {
        return productDao.find(id);
    }

    public List<Project> getProductsByAdmin(User admin){
        return productDao.getProductsByAdmin(admin);
    }

    public void updateUserStory(UserStory newUserStory, UUID userStoryId, UUID productId) throws Exception {
        Project pr = productDao.find(productId);
        List<UserStory> userStories = pr.getUserStories();
        UserStory us;
        for (UserStory userStory: userStories) {
            if(userStory.getId().equals(userStoryId)){
                us = userStory;
            }
        }
        us = newUserStory;
    }

    public void addNewUserStory(UserStory userStory, Project product) throws Exception {
        productDao.find(product.getId()).addNewUserStory(userStory);
    }

    public List<Project> getProductsByOwner(User user) {
        return productDao.getProductsByOwner(user);
    }
}
