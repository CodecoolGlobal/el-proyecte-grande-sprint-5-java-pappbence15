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

    @GetMapping("/admin/project/{projectId}")
    public String adminProductPage(Model model, @PathVariable UUID projectId) throws Exception {
        Product product = productService.getById(projectId);

        User user = userService.getLoggedInUser();

        model.addAttribute("user", user);
        UserType userType = user.getUserType();

        model.addAttribute("product", product);

        if (userType == UserType.ADMIN && product.getAdmins().contains(user)) {
            return "admin_project_view";
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/owner/project/{projectId}")
    public String ownerProductPage(Model model, @PathVariable UUID projectId) throws Exception {
        Product product = productService.getById(projectId);

        User user = userService.getLoggedInUser();

        model.addAttribute("user", user);
        UserType userType = user.getUserType();

        model.addAttribute("product", product);

        if (userType == UserType.PRODUCT_OWNER && product.getOwner().equals(user)){
            return "owner_project_view";
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
