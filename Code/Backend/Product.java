public class Product{
	private String productID;
	private String productName;
	private String description;
	private double price;
	private int quantity;

	public Product(String productID, String productName, double price, int quantity){
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductID(){
		return productID;
	}
	public void setProductID(String productID){
		this.productID = productID;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}

	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	//to format the products
	@Override
    public String toString() {
        return "Product{id='" + productID + "', name='" + productName + "', price=" + price + ", quantity=" + quantity + "}";
    }
}