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

package Code.Backend;

import Code.Backend.Product;

import java.io.*;
import java.util.*;

public class CartService {
    private List<Product> cart;
    private final String CART_FILE = "cart.txt";

    public CartService() {
        cart = new ArrayList<>();
        loadCartFromFile();
    }

    private void loadCartFromFile() {
        cart.clear();

        File file = new File(CART_FILE);
        if (!file.exists()) return;
    
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
    
                    boolean found = false;
                    for (Product p : cart) {
                        if (p.getProductID().equalsIgnoreCase(id)) {
                            p.setQuantity(p.getQuantity() + quantity);
                            found = true;
                            break;
                        }
                    }
    
                    if (!found) {
                        cart.add(new Product(id, name, price, quantity));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load cart: " + e.getMessage());
        }
    }

    public void addToCart(Product newProduct) {
        // Look for an existing product with the same ID
        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i);
            if (p.getProductID().equals(newProduct.getProductID())) {
                // Found it, update quantity manually
                int updatedQty = p.getQuantity() + newProduct.getQuantity();
                Product updatedProduct = new Product(p.getProductID(), p.getProductName(), p.getPrice(), updatedQty);
                cart.set(i, updatedProduct);
                saveCartToFile();
                return;
            }
        }
    
        // If not found, add new
        cart.add(new Product(
            newProduct.getProductID(),
            newProduct.getProductName(),
            newProduct.getPrice(),
            newProduct.getQuantity()
        ));
        saveCartToFile();
    }

    public void removeFromCart(String input) {
        cart.removeIf(p -> p.getProductID().equalsIgnoreCase(input) || p.getProductName().equalsIgnoreCase(input));
        saveCartToFile();
    }

    public void clearCart() {
        cart.clear();
        saveCartToFile();
    }

    public List<Product> getCartItems() {
        return cart;
    }

    public double getTotal() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    public boolean addProductToCart(String productName) {
        if (productName != null && !productName.isEmpty()) {
            Product product = new Product(UUID.randomUUID().toString(), productName, 100.0, 1);
            addToCart(product);
            return true;
        }
        return false;
    }

    public boolean removeProductFromCart(String productName) {
        if (productName != null && !productName.isEmpty()) {
            removeFromCart(productName);
            return true;
        }
        return false;
    }

    private void saveCartToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CART_FILE))) {
            for (Product p : cart) {
                if (p == null) {
                    System.out.println("Skipping null product during save.");
                    continue; // Skip null products
                }
    
                bw.write(String.format("%s, %s, %.2f, %d", p.getProductID(), p.getProductName(), p.getPrice(), p.getQuantity()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save cart: " + e.getMessage());
        }
    }
}
