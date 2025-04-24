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

package Code.Backend;

public class Product {
	private String productID;
	private String productName;
	private double price;
	private int quantity;

	public Product(String productID, String productName, double price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return productID + " : " + productName + " : " + price + " : " + quantity;
	}
}
