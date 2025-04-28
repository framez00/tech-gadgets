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
        File file = new File(CART_FILE);
        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    cart.add(new Product(id, name, price, quantity));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load cart.");
        }
    }

    public void addToCart(Product product) {
        cart.add(product);
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
                bw.write(String.format("%s, %s, %.2f, %d", p.getProductID(), p.getProductName(), p.getPrice(),
                        p.getQuantity()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("fail");
        }
    }
}
