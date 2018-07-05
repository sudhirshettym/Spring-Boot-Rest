package com.example.resources.v1;

import com.example.dto.v1.ProductDTO;
import com.example.dto.v1.ProductListDTO;
import com.example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ProductListDTO> getAllProducts() {
        return ResponseEntity.ok(new ProductListDTO(productService.getAllProducts()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }




}
