package com.example.services;

import com.example.domain.Product;
import com.example.dto.v1.ProductDTO;
import com.example.mapper.v1.ProductMapper;
import com.example.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    public static final Long id = 1L;
    public static final String name = "sudhir";

    ProductService productService;

    @Mock
    ProductRepository productRepository;

    ProductMapper productMapper = new ProductMapper();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository, productMapper);
    }

    @Test
    public void getAllCategories() {
        List<Product> productList = Arrays.asList(new Product(), new Product(), new Product());
        when(productRepository.getListProduct()).thenReturn(productList);
        List<ProductDTO> productDTOList = productService.getAllProducts();
        assertEquals(3, productDTOList.size());
    }

    @Test
    public void getCategoryByName() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);

        when(productRepository.getProductByName(anyString())).thenReturn(product);
        ProductDTO dto = productService.getProductByName(name);

        assertEquals(id, dto.getId());
        assertEquals(name, dto.getName());


    }
}
