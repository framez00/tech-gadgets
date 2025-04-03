import java.util.ArrayList;
import java.util.List;

public class CartController {
    private List<Cart> carts;

    public CartController() {
        this.carts = new ArrayList<>();
    }

    public boolean createCart(int cartID, int customerID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID) {
                return false; // Cart with this ID already exists
            }
        }
        carts.add(new Cart(cartID, customerID, 0, new Product[]{}));
        return true; // Cart created successfully
    }

    public Cart getCart(int cartID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID) {
                return cart;
            }
        }
        return null; // Return null if no cart is found
    }

    public boolean addProductToCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.addProduct(product);
            return true; // Product added successfully
        }
        return false; // Cart not found
    }

    public boolean removeProductFromCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.removeProduct(product);
            return true; // Product removed successfully
        }
        return false; // Cart not found
    }

    public float getCartTotalPrice(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            return cart.getTotalPrice();
        }
        return -1; // Return -1 if cart not found
    }

    public void listCartProducts(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            for (Product product : cart.getListProducts()) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        } else {
            System.out.println("Cart not found.");
        }
    }

    public boolean clearCart(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.setListProducts(new ArrayList<>());
            cart.setTotalPrice(0);
            return true; // Cart cleared successfully
        }
        return false; // Cart not found
    }
}
