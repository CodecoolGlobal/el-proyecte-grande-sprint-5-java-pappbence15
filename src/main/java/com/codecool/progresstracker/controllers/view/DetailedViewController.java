package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserStory;
import com.codecool.progresstracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class DetailedViewController {

    private final ProductService productService;

    @Autowired
    DetailedViewController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/detailedProductFeed")
    public String productPage(@RequestBody User user){
        return null;
    }

    @PostMapping("/detailedProductFeed/update")
    public void changeDetails(@RequestBody UserStory changedUserStory,
                                @RequestBody UUID userStoryId,
                                @RequestBody UUID productId) throws Exception {
        productService.updateUserStory(changedUserStory, userStoryId, productId);
    }

    @PutMapping("/detailedProductFeed/add")
    public void addNewUserStory(@RequestBody UserStory userStory,
                                @RequestBody Project product) throws Exception {
        productService.addNewUserStory(userStory, product);
    }
}
