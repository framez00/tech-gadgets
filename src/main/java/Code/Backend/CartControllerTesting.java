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

public class CartControllerTesting {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        CartController controller = new CartController(cartService);

        System.out.println("Adding product: Mouse");
        controller.addProduct("Mouse");

        System.out.println("Adding product: Laptop");
        controller.addProduct("Laptop");

        System.out.println("Removing product: Mouse");
        controller.removeProduct("Mouse");

        System.out.println("Clearing cart...");
        controller.clearCart();
    }
}
