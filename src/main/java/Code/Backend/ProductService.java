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

package Code.Backend;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        loadProductsFromClasspath("products.txt");
    }

    private void loadProductsFromClasspath(String fileName) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                System.out.println("products.txt not found in classpath.");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 5); // allow product names with commas
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    int quantity = Integer.parseInt(parts[3].trim());
                    products.add(new Product(id, name, price, quantity));
                }

            }
            br.close();
        } catch (Exception e) {
            System.out.println("Failed to load products: " + e.getMessage());
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
