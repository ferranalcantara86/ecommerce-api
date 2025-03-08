package com.ecommerce_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {
    @Id
    private String id;  // 🔹 Cambiado de Long a String para usarlo en memoria

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    private LocalDateTime lastUpdated;

    public Cart() {
        this.lastUpdated = LocalDateTime.now();
    }

    public Cart(String id) {  // 🔹 Nuevo constructor que recibe ID
        this.id = id;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }  // 🔹 Agregado para asignar ID manualmente

    public List<Product> getProducts() { return products; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }

    public void addProduct(Product product) {
        this.products.add(product);
        this.lastUpdated = LocalDateTime.now();
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        this.lastUpdated = LocalDateTime.now();
    }

    public void clearCart() {
        this.products.clear();
        this.lastUpdated = LocalDateTime.now();
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
