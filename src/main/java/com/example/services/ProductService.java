package com.example.services;

import com.example.dto.v1.ProductDTO;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public ProductDTO getProductByName(String name);
}
