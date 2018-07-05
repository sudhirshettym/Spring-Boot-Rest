package com.example.repositories;

import com.example.domain.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getListProduct();

    public Product getProductByName(String name);
}
