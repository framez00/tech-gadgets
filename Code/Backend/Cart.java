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
