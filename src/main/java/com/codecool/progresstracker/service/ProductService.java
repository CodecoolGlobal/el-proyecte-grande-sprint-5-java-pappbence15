package com.codecool.progresstracker.service;

import com.codecool.progresstracker.dao.ProductDao;
import com.codecool.progresstracker.dao.UserDao;
import com.codecool.progresstracker.model.Product;
import com.codecool.progresstracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;
    private final UserDao userDao;

    @Autowired
    public ProductService(ProductDao productDao, UserDao userDao) {
        this.productDao = productDao;
        this.userDao = userDao;
        addAProductWithTestUserAsAdmin();
    }

    public void addAProductWithTestUserAsAdmin(){
        User user = userDao.getFirstUser();
        List<User> adminList = new ArrayList<>();
        adminList.add(user);
        Product product = new Product("Building a house on Firefly Lane", null, adminList);
        productDao.add(product);
    }

    public List<Product> getProductsByAdmin(User admin){
        return productDao.getProductsByAdmin(admin);
    }
}
