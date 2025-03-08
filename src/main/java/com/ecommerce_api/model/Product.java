package com.ecommerce_api.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double price;

    public Product() {}
    public Product(Long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { 
        this.description = (description != null && !description.trim().isEmpty()) ? description : this.description;
    }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { 
        this.price = (price >= 0) ? price : this.price;
    }
}