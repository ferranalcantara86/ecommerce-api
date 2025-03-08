package com.ecommerce_api.service;

import com.ecommerce_api.model.Cart;
import com.ecommerce_api.model.Product;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartService {
    private final Map<String, Cart> carts = new ConcurrentHashMap<>();
    private static final int EXPIRATION_TIME = 10;

    public String createCart() {
        String cartId = UUID.randomUUID().toString();
        Cart cart = new Cart(cartId);  // ✅ Usa el constructor con ID
        carts.put(cartId, cart);
        return cartId;
    }

    public Cart getCart(String cartId) {
        cleanExpiredCarts();
        return carts.get(cartId);
    }

    public boolean addProductToCart(String cartId, Product product) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.addProduct(product);
            return true;
        }
        return false;
    }

    public boolean deleteCart(String cartId) {
        return carts.remove(cartId) != null;
    }

    @Scheduled(fixedRate = 60000)
    public void cleanExpiredCarts() {
        LocalDateTime now = LocalDateTime.now();
        carts.entrySet().removeIf(entry -> 
            Duration.between(entry.getValue().getLastUpdated(), now).toMinutes() > EXPIRATION_TIME
        );
    }
}
