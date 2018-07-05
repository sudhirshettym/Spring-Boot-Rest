package com.example.dto.v1;

import java.util.List;

public class ProductListDTO {
    List<ProductDTO> products;

    public ProductListDTO(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
