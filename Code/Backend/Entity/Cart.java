import java.util.ArrayList;

public class Cart{
	private int cartID;
	private int customerID;
	private float totalPrice;
	private ArrayList<Product> listOfProducts;

	public Cart(int cartID, int customerID, float totalPrice, Product[]listOfProducts){
		this.cartID = cartID;
		this.customerID = customerID;
		this.totalPrice = totalPrice;
	} 

	public int getCartID(){
		return cartID;
	}

	public int getCustomerID(){
		return customerID;
	}

	public float getTotalPrice(){
		return totalPrice;
	}

	public ArrayList<Product> getList(){
		return listOfProducts;
	}


	public void setCartID(int cartID){
		this.cartID = cartID;
	}

	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}

	public void setTotalPrice(float totalPrice){
		this.totalPrice = totalPrice;
	}

	public void setListOfProducts(ArrayList<Product> listOfProducts){
		this.listOfProducts = listOfProducts;
	}
}