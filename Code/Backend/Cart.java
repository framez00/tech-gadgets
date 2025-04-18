/**
 * Class Name: Cart
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * This class models a shopping cart in our e-commerce system called infinifty tech. It stores the cart ID, customer ID,
 * a list of products in the cart, and the total price. It provides methods for adding and removing
 * products, as well as retrieving and modifying the cart's contents and metadata.
 *
 * Key Methods:
 * - Cart(int cartID, int customerID, float totalPrice, Product[] initialProducts):
 *
 * - addProduct(String productID, Product product):
 *   Adds a product to the cart if the product's ID matches the specified productID.
 *
 * - removeProduct(String productID):
 *   Removes the product with the given productID from the cart.
 *
 * - Getter and Setter methods:
 *   Access and modify cart metadata including cart ID, customer ID, total price, and product list.
 *
 * Data Structures:
 * - ArrayList<Product>: Used to store products added to the cart, allowing dynamic resizing and fast access.
 *
 * Algorithm Notes:
 * - Product search in removeProduct() is done using a simple linear search, which is efficient for small product lists.
 *   For large carts, a HashMap<ProductID, Product> would be more efficient.
 */
import java.util.ArrayList;

public class Cart {
    private int cartID;
    private int customerID;
    private float totalPrice;
    private ArrayList<Product> listProducts;

    public Cart(int cartID, int customerID, float totalPrice, Product[] initialProducts) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.totalPrice = totalPrice;
        this.listProducts = new ArrayList<>();
        if (initialProducts != null) {
            for (Product product : initialProducts) {
                this.listProducts.add(product);
                this.totalPrice += product.getPrice(); 
            }
        }
    }

    public int getCartID() { return cartID; }
    public int getCustomerID() { return customerID; }
    public float getTotalPrice() { return totalPrice; }
    public ArrayList<Product> getList() { return listProducts; }

    public void setCartID(int cartID) { this.cartID = cartID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }
    public void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }
    public void setListOfProducts(ArrayList<Product> listProducts) { this.listProducts = listProducts; }

    public void addProduct(String productID, Product product) {
        if (product != null && product.getProductID().equals(productID)) {
            listProducts.add(product);
            totalPrice += product.getPrice(); 
        }
    }

    public void removeProduct(String productID) {
        Product toRemove = null;
        for (Product p : listProducts) {
            if (p.getProductID().equals(productID)) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            listProducts.remove(toRemove);
            totalPrice -= toRemove.getPrice(); 
        }
    }
}
