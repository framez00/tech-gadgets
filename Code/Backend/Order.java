import java.util.ArrayList;

public class Order{
	private String orderID;
	private String customerID;
	private ArrayList<Product> productList;
	private double price;
	private String orderDate;
	private String status;

	public Order(String orderID, String customerID, double price, String orderDate, String status, ArrayList<Product> productList){
		this.orderID = orderID;
		this.customerID = customerID;
		this.price = price;
		this.orderDate = orderDate;
		this.status = status;
		this.productList = productList;
	}

	public String getOrderID(){
		return orderID;
	}
	public String getCustomerID(){
		return customerID;
	}
	public double getPrice(){
		return price;
	}
	public String getOrderDate(){
		return orderDate;
	}
	public String getStatus(){
		return status;
	}
	public ArrayList<Product> getProductList(){
		return productList;
	}
	

	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
	public void setCustomerID(String customerID){
		this.customerID = customerID;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public void setProductList(ArrayList<Product> productList){
		this.productList = productList;
	}
}