package com.example.services;

import com.example.domain.Product;
import com.example.dto.v1.ProductDTO;
import com.example.mapper.v1.ProductMapper;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> listProduct = productRepository.getListProduct();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : listProduct) {
            productDTOList.add(mapper.map(product));
        }
        return productDTOList;
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.getProductByName(name);
        ProductDTO dto = mapper.map(product);
        return dto;
    }
}
