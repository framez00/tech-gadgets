/**
 * Class Name: Cart
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * Maintains the list of items in a cart and provides operations for total pricing,
 * adding/removing products, and clearing the cart.
 *
 * Key Methods:
 * - addProduct(Product, int): Adds a product or updates quantity.
 * - removeProduct(String): Removes a product by ID.
 * - clearCart(): Clears the cart.
 * - getTotalPrice(): Calculates total cost.
 *
 * Data Structures:
 * - List<CartItem>: Internal list of cart items.
 */
package com.infinitytech.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeProduct(String productId) {
        items.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public void clearCart() {
        items.clear();
    }
}
