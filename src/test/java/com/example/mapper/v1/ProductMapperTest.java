package com.example.mapper.v1;

import com.example.domain.Product;
import com.example.dto.v1.ProductDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductMapperTest {
    private static final String NAME = "sudhir";
    private static final Long ID = 1L;

    ProductMapper mapper = new ProductMapper();

    @Test
    public void categoryDTOfromProduct() {
        Product product = new Product();
        product.setName(NAME);
        product.setId(ID);

        ProductDTO productDTO = mapper.map(product);

        assertEquals(ID, productDTO.getId());
        assertEquals(NAME, productDTO.getName());

    }


}
