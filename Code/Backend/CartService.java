/**
 * Class Name: CartService
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * Handles cart logic such as adding, removing, and clearing products, and reads/writes from a text file.
 *
 * Key Methods:
 * - addProductToCart(String): Adds product to cart by name.
 * - removeProductFromCart(String): Removes product by name.
 * - clearCart(): Clears the cart.
 * - getCartItems(): Returns current items.
 * - getTotalPrice(): Returns subtotal.
 *
 * Data Structures:
 * - Cart: Manages internal cart state.
 *
 * Algorithms:
 * - Stream filtering (getProductByName): Simple and sufficient for small in-memory product list.
 */
package com.infinitytech.ecommerce.service;

import com.infinitytech.ecommerce.model.Cart;
import com.infinitytech.ecommerce.model.CartItem;
import com.infinitytech.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class CartService {

    private static final String CART_FILE_PATH = "src/main/resources/cart.txt";
    private final Cart cart = new Cart();
    private final ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
        loadCartFromFile();
    }

    private void loadCartFromFile() {
        cart.clearCart();
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 6);
                if (parts.length == 6) {
                    Product product = new Product(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        Double.parseDouble(parts[4].trim())
                    );
                    int qty = Integer.parseInt(parts[5].trim());
                    cart.addProduct(product, qty);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCartToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE_PATH))) {
            for (CartItem item : cart.getItems()) {
                Product p = item.getProduct();
                writer.write(String.join(",", p.getId(), p.getName(), p.getCategory(),
                        p.getDescription(), String.valueOf(p.getPrice()), String.valueOf(item.getQuantity())));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addProductToCart(String productName) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            cart.addProduct(product, 1);
            saveCartToFile();
            return true;
        }
        return false;
    }

    public boolean removeProductFromCart(String productName) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            cart.removeProduct(product.getId());
            saveCartToFile();
            return true;
        }
        return false;
    }

    public void clearCart() {
        cart.clearCart();
        saveCartToFile();
    }

    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
}
