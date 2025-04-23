/**
 * a) Class Name: Product
 * b) Date: April 15, 2025
 * c) Programmer: Fahim Ramez
 * d) Description: 
 *    This class represents a product in an inventory system. It contains details such as 
 *    product ID, name, description, price, and quantity in stock. It provides getter and 
 *    setter methods to access and update the information.
 * 
 * e) Important Functions:
 *    - Constructor: Initializes productID, productName, price, and quantity.
 *    - Getter and setter methods for each field.
 * 
 * f) Data Structures:
 *    - Uses basic data types: String (for product ID, name, description), 
 *      double (for price), and int (for quantity).
 * 
 * g) Algorithms:
 *    - No algorithms are used
 */
public class Product {
    private String productID;
    private String productName;
    private String category;
    private double price;

    public Product(String productID, String productName, String category, double price) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productID + " : " + productName + " : " + category + " : $" + price;
    }
}
