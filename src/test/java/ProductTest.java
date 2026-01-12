package com.example.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductInStock() {
        Product product = new Product("P001", "Laptop", 999.99, 5);
        assertTrue(product.isInStock());
    }

    @Test
    public void testProductOutOfStock() {
        Product product = new Product("P002", "Mouse", 29.99, 0);
        assertFalse(product.isInStock());
    }

    // BUG: This test doesn't cover negative quantities
}
