package com.infinitytech.ecommerce.model;

public class Product {
    private String name;
    private String category;
    private double price;

    // ✅ Default constructor (required for serialization)
    public Product() {}

    // ✅ Constructor with fields
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // ✅ Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
