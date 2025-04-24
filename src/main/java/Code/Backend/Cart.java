/**
 * Class Name: Cart
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes 2
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
package Code.Backend;

import Code.Backend.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void addProduct(Product product) {
        items.add(new CartItem(product));
    }

    public void removeProduct(String productId) {
        items.removeIf(item -> item.getProduct().getProductID().equals(productId));
    }

    public void clearCart() {
        items.clear();
    }
}
