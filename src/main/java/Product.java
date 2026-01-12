package com.example.models;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // TODO: Implement discount calculation
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    // FIXME: Need to handle concurrent updates
    public void updateQuantity(int delta) {
        quantity += delta;
    }
}
