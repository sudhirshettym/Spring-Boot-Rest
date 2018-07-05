package com.example.controllers.v1;

import com.example.dto.v1.ProductDTO;
import com.example.resources.v1.ProductResource;
import com.example.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductResourceTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductResource productResource;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
    }

    @Test
    public void testGetAllProducts() throws Exception{

        ProductDTO dto1 = new ProductDTO();
        dto1.setName("product1");
        dto1.setId(1L);

        ProductDTO dto2 = new ProductDTO();
        dto2.setId(2L);
        dto2.setName("product2");

        when(productService.getAllProducts()).thenReturn(Arrays.asList(dto1, dto2));


        mockMvc.perform(get("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(2)));
    }

    @Test
    public void testGetProductByName() throws Exception{

        ProductDTO dto = new ProductDTO();
        dto.setName("product1");
        dto.setId(1L);
        ResultActions actions = mockMvc.perform(get("/api/v1/products/product1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", equalTo("product1")));
    }
}
