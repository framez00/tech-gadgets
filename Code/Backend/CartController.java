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
                return false; 
            }
        }
        carts.add(new Cart(cartID, customerID, 0, new Product[]{}));
        return true; 
    }

    public Cart getCart(int cartID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID) {
                return cart;
            }
        }
        return null; 
    }

    public boolean addProductToCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.addProduct(product);
            return true; 
        }
        return false; 
    }

    public boolean removeProductFromCart(int cartID, Product product) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            cart.removeProduct(product);
            return true; 
        }
        return false; 
    }

    public float getCartTotalPrice(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            return cart.getTotalPrice();
        }
        return -1; 
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
            return true; 
        }
        return false; 
    }
}
