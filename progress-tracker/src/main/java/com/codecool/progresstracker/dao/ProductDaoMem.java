package com.codecool.progresstracker.dao;

import com.codecool.progresstracker.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoMem {
    private List<Product> products;

    public ProductDaoMem() {
        this.products = new ArrayList<>();
    }


}
