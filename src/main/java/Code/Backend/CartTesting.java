/**
 * Class Name: CartTesting
 * Date: April 28, 2025
 * Programmer: Vardges Gasparyan
 *
 * Description:
 * Test cart class, demonstrates adding products to a cart, listing items,
 *  calculating the total price, removing an item, and updating the cart.
 *
 *
 */

package Code.Backend;

import Code.Backend.Cart;
import Code.Backend.CartItem;
import Code.Backend.Product;

public class CartTesting {

    public static void main(String[] args) {
        Cart cart = new Cart();

        Product p1 = new Product("P01", "Laptop", 1000.0, 5);
        Product p2 = new Product("P02", "Mouse", 20.0, 10);

        cart.addProduct(p1);
        cart.addProduct(p2);

        System.out.println("\nCart Items:");
        for (CartItem item : cart.getItems()) {
            System.out.println(item);
        }

        System.out.println("\nTotal Price: $" + cart.getTotalPrice());

        System.out.println("\nRemoving Laptop (P01) from cart...");
        cart.removeProduct("P01");

        System.out.println("\nCart Items after removal:");
        for (CartItem item : cart.getItems()) {
            System.out.println(item);
        }

        System.out.println("\nTotal Price after removal: $" + cart.getTotalPrice());
    }
}
