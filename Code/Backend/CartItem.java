/**
 * Class Name: CartItem
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * data structure representing a single item in the cart, including its quantity and associated product.
 *
 * Key Methods:
 * - getTotalPrice(): Calculates the total price for this item.
 *
 * Data Structures:
 * - Product: Represents the product.
 */
package com.infinitytech.ecommerce.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem() {}

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
