package com.ecommerce_api.controller;

import com.ecommerce_api.model.Cart;
import com.ecommerce_api.model.Product;
import com.ecommerce_api.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCart() {
        return ResponseEntity.ok(cartService.createCart());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {
        Optional<Cart> cart = Optional.ofNullable(cartService.getCart(cartId));
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{cartId}/add-product")
    public ResponseEntity<Void> addProduct(@PathVariable String cartId, @RequestBody @Valid Product product) {
        boolean added = cartService.addProductToCart(cartId, product);
        return added ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        boolean deleted = cartService.deleteCart(cartId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
