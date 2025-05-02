/**
 * Class Name: CartControllerTesting
 * Date: April 28, 2025
 * Programmer: Vardges Gasparyan
 *
 * Description:
 * Test Cart Controller, It tests adding products to the cart, 
 * removing a product from the cart, and clearing the entire cart. 
 * This testing ensures that the CartController correctly interacts with the CartService to perform 
 * cart operations without errors.
 *

 */

package Code.Backend;

import java.util.List;

public class CartControllerTesting {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        CartController controller = new CartController(cartService);

        runTest("Add 'Mouse' to cart", () -> {
            controller.clearCart();
            controller.addProduct("Mouse");
            return cartContainsProduct(cartService.getCartItems(), "Mouse", 1);
        });

        runTest("Add 'Laptop' to cart", () -> {
            controller.clearCart();
            controller.addProduct("Laptop");
            return cartContainsProduct(cartService.getCartItems(), "Laptop", 1);
        });

        runTest("Remove 'Mouse' from cart", () -> {
            controller.clearCart();
            controller.addProduct("Mouse");
            controller.removeProduct("Mouse");
            return cartDoesNotContainProduct(cartService.getCartItems(), "Mouse");
        });

        runTest("Clear cart", () -> {
            controller.clearCart();
            controller.addProduct("Mouse");
            controller.addProduct("Laptop");
            controller.clearCart();
            return cartService.getCartItems().isEmpty();
        });
    }

    private static void runTest(String testName, TestFunction test) {
        try {
            boolean passed = test.run();
            System.out.println(testName + " - " + (passed ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println(testName + " - EXCEPTION: " + e.getMessage());
        }
        System.out.println();
    }

    private static boolean cartContainsProduct(List<Product> products, String name, int expectedSize) {
        return products.stream().anyMatch(p -> p.getProductName().equals(name)) && products.size() == expectedSize;
    }

    private static boolean cartDoesNotContainProduct(List<Product> products, String name) {
        return products.stream().noneMatch(p -> p.getProductName().equals(name));
    }

    @FunctionalInterface
    interface TestFunction {
        boolean run() throws Exception;
    }
}
