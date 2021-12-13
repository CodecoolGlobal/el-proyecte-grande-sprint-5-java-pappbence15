package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductDaoMem implements ProductDao{
    private final List<Project> products;

    public ProductDaoMem() {
        this.products = new ArrayList<>();
    }


    @Override
    public void add(Project product) {
        this.products.add(product);
    }

    @Override
    public Project find(UUID id) throws Exception {
        for (Project product : products) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        throw new Exception("ProductNotFound");
    }

    @Override
    public List<Project> getAll() {
        return products;
    }

    @Override
    public List<Project> getProductsByOwner(User user) {
        List<Project> productsOfUser = new ArrayList<>();
        for (Project product : products) {
            if (product.getOwner().equals(user)){
                productsOfUser.add(product);
            }
        }
        return productsOfUser;
    }

    @Override
    public List<Project> getProductsByAdmin(User user) {
        List<Project> productsOfUser = new ArrayList<>();
        for (Project product : products) {
            if (product.getAdmins().contains(user)){
                productsOfUser.add(product);
            }
        }
        return productsOfUser;
    }
}
