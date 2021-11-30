package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Product;
import com.codecool.progresstracker.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductDao {

    void add(Product product);
    Product find(UUID id) throws Exception;

    List<Product> getAll();
    List<Product> getProductsByOwner(User user);
    List<Product> getProductsByAdmin(User user);
}
