import java.util.ArrayList;
import java.util.List;

public class CartController {
    private List<Cart> carts;

    public CartController() {
        this.carts = new ArrayList<>();
    }

    public void createCart(int cartID, int customerID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID) {
                throw new IllegalArgumentException("Cart with this ID already exists.");
            }
        }
        carts.add(new Cart(cartID, customerID, 0, new Product[]{}));
    }

    public Cart getCart(int cartID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID) {
                return cart;
            }
        }
        return null; // Return null if no cart is found
    }

    public void addProductToCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.addProduct(product);
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public void removeProductFromCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.removeProduct(product);
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public float getCartTotalPrice(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null)
