import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class CartController {
    private Map<Integer, Cart> carts;

    public CartController() {
        this.carts = new HashMap<>();
    }

    public void createCart(int cartID, int customerID) {
        if (!carts.containsKey(cartID)) {
            carts.put(cartID, new Cart(cartID, customerID, 0, new Product[]{}));
        } else {
            throw new IllegalArgumentException("Cart with this ID already exists.");
        }
    }

    public Cart getCart(int cartID) {
        return carts.get(cartID);
    }

    public void addProductToCart(int cartID, Product product) {
        Cart cart = carts.get(cartID);
        if (cart != null) {
            cart.addProduct(product);
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public void removeProductFromCart(int cartID, Product product) {
        Cart cart = carts.get(cartID);
        if (cart != null) {
            cart.removeProduct(product);
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public float getCartTotalPrice(int cartID) {
        Cart cart = carts.get(cartID);
        if (cart != null) {
            return cart.getTotalPrice();
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public void listCartProducts(int cartID) {
        Cart cart = carts.get(cartID);
        if (cart != null) {
            for (Product product : cart.getListProducts()) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }

    public void clearCart(int cartID) {
        Cart cart = carts.get(cartID);
        if (cart != null) {
            cart.setListProducts(new ArrayList<>());
            cart.setTotalPrice(0);
        } else {
            throw new IllegalArgumentException("Cart not found.");
        }
    }
}
