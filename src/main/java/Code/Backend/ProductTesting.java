package Code.Backend;

import Code.Backend.Product;
import Code.Backend.ProductController;

public class ProductTesting {

    public static void main(String[] args) {
        ProductController controller = new ProductController();

        // Load existing products from file
        controller.loadProducts();
        System.out.println("Products loaded from file:");
        controller.listAllProducts();

        // Add a new product
        System.out.println("\nAdding a new product:");
        Product newProduct = new Product("11", "Mouse", 9.99, 10);
        controller.addProduct(newProduct, "11");
        controller.saveProducts(); // Save to file
        System.out.println("After adding new product:");
        controller.listAllProducts();

        // Remove a product
        System.out.println("\nRemoving product 01:");
        controller.removeProduct("01");
        controller.saveProducts(); // Save updated list
        controller.listAllProducts();

        // Check if product 02 exists
        System.out.println("\nDoes product 02 exist?");
        boolean exists = controller.doesProductExist("02");
        System.out.println(exists ? "Yes" : "No");

        // Check if product 01 exists
        System.out.println("\nDoes product 01 exist?");
        boolean exists2 = controller.doesProductExist("01");
        System.out.println(exists2 ? "Yes" : "No");
    }  
 
} 