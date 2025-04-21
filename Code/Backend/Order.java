import java.util.ArrayList;

public class Order{
	private int orderID;
	private int customerID;
	private ArrayList<Product> productList;
	private double price;
	private String orderDate;
	private String status;

	public Order(int orderID, int customerID, ArrayList<Product> productList, double price, String orderDate, String status){
		this.orderID = orderID;
		this.customerID = customerID;
		this productList = productList;
		this.price = price;
		this.orderDate = orderDate;
		this.status = status;
	}

	public int getOrderID(){
		return orderID;
	}
	public int getCustomerID(){
		return customerID;
	}
	public ArrayList<Product> getProductList(){
		return productList;
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
	

	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	public void setProductList(ArrayList<Product> productList){
		this.productList = productList;
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
}