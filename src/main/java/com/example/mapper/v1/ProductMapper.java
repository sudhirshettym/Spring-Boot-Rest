package com.example.mapper.v1;

import com.example.domain.Product;
import com.example.dto.v1.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO map(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        return dto;
    }

}
