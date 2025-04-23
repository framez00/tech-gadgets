/**
 * Class Name: ProductService
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * Reads product data from a file and provides product retrieval and search functionality.
 *
 * Key Methods:
 * - getAllProducts(): Returns all products.
 * - getProductByName(String): Finds a product by name.
 * - searchProducts(String): Returns products filtered by query.
 *
 * Data Structures:
 * - List<Product>: Stores all available products.
 *
 * Algorithms:
 * - File parsing using BufferedReader.
 * - Stream filtering for search functionality: clean, efficient for in-memory usage.
 */
import java.io.*;
import java.util.*;

public class ProductService {
    private List<Product> products;

    public ProductService(String filename) {
        products = new ArrayList<>();
        loadProductsFromFile(filename);
    }

    private void loadProductsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String category = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    products.add(new Product(id, name, category, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load products.");
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findProductByIdOrName(String input) {
        for (Product p : products) {
            if (p.getProductID().equalsIgnoreCase(input) || p.getProductName().equalsIgnoreCase(input)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
