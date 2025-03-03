public class Product{
	private String productID;
	private String productName;
	private String description;
	private double price;
	private int quantity;

	public Product(String productID, String productName, String description, double price, int quantity){
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
}