package com.codecool.progresstracker.controllers.view;

import com.codecool.progresstracker.model.Product;
import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.model.UserType;
import com.codecool.progresstracker.service.ProductService;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Controller
public class SketchyViewController {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public SketchyViewController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/projectSketchyFeed/{projectId}")
    public String productPage(Model model, @PathVariable UUID projectId) throws Exception {
        Product product = productService.getById(projectId);

        User user = userService.getTestAdmin(); //TODO: replace with getting currently logged in user

        model.addAttribute("user", user);
        UserType userType = user.getUserType();

        model.addAttribute("product", product);

        if (userType == UserType.ADMIN && product.getAdmins().contains(user)) {

            return "project_sketchy_view";
        } else if (userType == UserType.ADMIN && product.getOwner().equals(user)){
            return "project_sketchy_view";
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
