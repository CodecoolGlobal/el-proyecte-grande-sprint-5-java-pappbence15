package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Product;
import com.codecool.progresstracker.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDaoMem implements ProductDao{
    private List<Product> products;

    public ProductDaoMem() {
        this.products = new ArrayList<>();
    }


    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public Product find(UUID id) throws Exception {
        for (Product product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        throw new Exception("ProductNotFound");
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public List<Product> getProductsByOwner(User user) {
        List<Product> productsOfUser = new ArrayList<>();
        for (Product product : products) {
            if (product.getOwner().equals(user)){
                productsOfUser.add(product);
            }
        }
        return productsOfUser;
    }

    @Override
    public List<Product> getProductsByAdmin(User user) {
        List<Product> productsOfUser = new ArrayList<>();
        for (Product product : products) {
            if (product.getAdmins().contains(user)){
                productsOfUser.add(product);
            }
        }
        return productsOfUser;
    }
}
