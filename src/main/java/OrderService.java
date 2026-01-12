package com.example.services;

import com.example.models.Product;
import com.example.models.User;

public class OrderService {

    // TODO: Add database connection
    public void processOrder(User user, Product product, int quantity) {
        if (!product.isInStock()) {
            throw new IllegalStateException("Product out of stock");
        }

        // BUG: Not checking if user is authenticated
        product.updateQuantity(-quantity);

        System.out.println("Order processed for " + user.getUsername());
    }

    // DEPRECATED: Use processOrder instead
    public void createOrder(User user, Product product) {
        processOrder(user, product, 1);
    }
}
