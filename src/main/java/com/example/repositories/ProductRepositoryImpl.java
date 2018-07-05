package com.example.repositories;

import com.example.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products = Arrays.asList(new Product(1L, "sudhir"),
            new Product(2L, "sudhir2"), new Product(3L, "sudhir3"));

    @Override
    public List<Product> getListProduct() {
        return products;
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }
}
