/**
 * Class Name: CartController
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * This controller manages shopping cart operations such as adding, removing,
 * and clearing products from the cart via REST API endpoints.
 *
 * Key Methods:
 * - addProduct(String productName): Adds a product to the cart.
 * - removeProduct(String productName): Removes a product from the cart.
 * - clearCart(): Empties the cart.
 * - getCart(): Returns cart contents and subtotal.
 *
 * Data Structures:
 * - Map<String, Object>: Used to return a structured response containing cart summary.
 */
package Code.Backend;

import Code.Backend.CartItem;
import Code.Backend.CartService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public String addProduct(String productName) {
        if (cartService.addProductToCart(productName)) {
            return "Product added";
        }
        return "Product not found";
    }

    public String removeProduct(String productName) {
        if (cartService.removeProductFromCart(productName)) {
            return "Product removed";
        }
        return "Product not found";
    }

    public String clearCart() {
        cartService.clearCart();
        return "Cart emptied";
    }

    public Map<String, Object> getCart() {
        List<Product> items = cartService.getCartItems();
        double total = cartService.getTotal();

        Map<String, Object> response = new HashMap<>();
        response.put("itemsInCart", items);
        response.put("subTotal", total);
        response.put("itemCount", items.size());

        return response;
    }
}
