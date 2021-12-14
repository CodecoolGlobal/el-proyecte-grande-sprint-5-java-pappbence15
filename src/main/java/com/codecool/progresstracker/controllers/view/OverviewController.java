package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProductService;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
public class OverviewController {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OverviewController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @ResponseBody
    @GetMapping("/admin/projects")
    public List<Project> adminProjectsView(){
        User user = userService.getLoggedInUser();
        UserType userType = user.getUserType();
        if(userType.equals(UserType.ADMIN)){
            return productService.getProductsByAdmin(user);
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/owner/projects")
    public String ownerProjectsView(Model model){
        User user = userService.getLoggedInUser();
        model.addAttribute("user", user);
        UserType userType = user.getUserType();
        if(userType.equals(UserType.PRODUCT_OWNER)){
            List<Project> products = productService.getProductsByOwner(user);
            model.addAttribute("products", products);
            return "owner_all_projects";
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
