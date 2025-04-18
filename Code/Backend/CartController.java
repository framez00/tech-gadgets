/**
 * Class Name: CartController
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * This controller manages shopping cart operations such as adding, removing,
 * and clearing products from the cart via REST API endpoints.
 *
 * Key Methods:
 * - addProduct(String productName): Adds a product to the cart.
 * - removeProduct(String productName): Removes a product from the cart.
 * - clearCart(): Empties the cart.
 * - getCart(): Returns cart contents and subtotal.
 *
 * Data Structures:
 * - Map<String, Object>: Used to return a structured response containing cart summary.
 */
package com.infinitytech.ecommerce.controller;

import com.infinitytech.ecommerce.model.CartItem;
import com.infinitytech.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam String productName) {
        if (cartService.addProductToCart(productName)) {
            return ResponseEntity.ok("Product added");
        }
        return ResponseEntity.status(404).body("NOT Ffound");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeProduct(@RequestParam String productName) {
        if (cartService.removeProductFromCart(productName)) {
            return ResponseEntity.ok("Product removed");
        }
        return ResponseEntity.status(404).body("NOT FOUND");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok("Cart emptied");
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCart() {
        List<CartItem> items = cartService.getCartItems();
        double total = cartService.getTotalPrice();

        Map<String, Object> response = new HashMap<>();
        response.put("items in cart", items);
        response.put("Sub-total", total);
        response.put("count", items.size());

        return ResponseEntity.ok(response);
    }
}
