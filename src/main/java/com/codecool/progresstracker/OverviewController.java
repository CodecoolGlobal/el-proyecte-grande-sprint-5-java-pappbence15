package com.codecool.progresstracker;

import com.codecool.progresstracker.dao.UserDao;
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
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
public class OverviewController {
    private final UserDao userDao; //TODO: get rid of this by adding service layer between controller and DAO
    private final UserService userService;
    private final ProductService productService; //like here

    @Autowired
    public OverviewController(UserDao userDao, UserService userService, ProductService productService) {
        this.userDao = userDao;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/newsfeed")
    public String productPage(Model model){
        User user = userService.getTestAdmin();
        model.addAttribute("user", user);
        UserType userType = user.getUserType();
        if(userType.equals(UserType.PRODUCT_OWNER)){
            return "index";
        }else if(userType.equals(UserType.ADMIN)){
            List<Product> products = productService.getProductsByAdmin(user);
            model.addAttribute("products", products);
            return "admin-index";
        }else{
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
