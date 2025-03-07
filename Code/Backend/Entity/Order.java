public class Order{
	private int orderID;
	private int customerID;
	private double total;
	private double tax;
	private String status;

	public Order(int orderID, int customerID, double total, double tax, String status){
		this.orderID = orderID;
		this.customerID = customerID;
		this.total = total;
		this.tax = tax;
		this.status = status;
	}

	public int getOrderID(){
		return orderID;
	}
	public int getCustomerID(){
		return customerID;
	}
	public double getTotal(){
		return total;
	}
	public double getTax(){
		return tax;
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
	public void setTotal(double total){
		this.total = total;
	}
	public void setTax(double tax){
		this.tax = tax;
	}
	public void setStatus(String status){
		this.status = status;
	}
}