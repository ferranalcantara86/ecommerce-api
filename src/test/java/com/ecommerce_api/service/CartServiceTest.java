package com.ecommerce_api.service;

import com.ecommerce_api.model.Cart;
import com.ecommerce_api.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    private CartService cartService;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
    }

    @Test
    void testCreateCart() {
        String cartId = cartService.createCart();
        assertNotNull(cartId);
        assertNotNull(cartService.getCart(cartId));
    }

    @Test
    void testGetCart() {
        String cartId = cartService.createCart();
        Cart cart = cartService.getCart(cartId);
        assertNotNull(cart);
        assertEquals(cartId, cart.getId());
    }

    @Test
    void testAddProductToCart() {
        String cartId = cartService.createCart();
        Product product = new Product(1L, "Laptop HP", 899.99);
        
        boolean added = cartService.addProductToCart(cartId, product);
        Cart cart = cartService.getCart(cartId);
        
        assertTrue(added);
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void testDeleteCart() {
        String cartId = cartService.createCart();
        boolean deleted = cartService.deleteCart(cartId);
        assertTrue(deleted);
        assertNull(cartService.getCart(cartId));
    }

    @Test
    void testCartExpiration() {
        // Crear carrito
        String cartId = cartService.createCart();
        
        // Simular que han pasado 11 minutos
        Cart cart = cartService.getCart(cartId);
        cart.setLastUpdated(LocalDateTime.now().minusMinutes(11));  

        // Ejecutar limpieza
        cartService.cleanExpiredCarts();

        // Verificar que el carrito ha sido eliminado
        assertNull(cartService.getCart(cartId));
    }
}
