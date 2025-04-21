import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrderController{
	private ArrayList<Order> orders;

	public OrderController() {
		this.orders = new ArrayList<>();
	}

	public void addOrder(Order order){
		orders.add(order);
	}

	public void removeOrder(String orderID){
		//go through the list and loop
        for(Order order : orders){

            //if orderID is found, remove
            if(order.getOrderID().equals(orderID)){
                orders.remove(order);
                System.out.println("Order with orderID " + order + " has been removed.");
                return true;
            }
        }
        //if not, it doesnt exist
        System.out.println("Order does not exist.");
        return false;
	}

	public ArrayList<Order> listAllOrders() {
		for(Order order : orders){
            System.out.println(order.getOrderID() + ", " + order.getCustomerID() + ", " + order.getProductList() + ", " +
                               order.getPrice() + ", " + order.getOrderData() + ", " + order.getStatus());
        }
        return orders;
	}

	public boolean doesOrderExist(String orderID) {
		for(Order order : orders){
            if(order.getOrderID().equals(orderID)){
                System.out.println("Order exists.");
                return true;
            }
        }
        System.out.println("Order does not exist.");
        return false;
	}

	/* this method searches through the orders list and looks for a customer id, to list
	   all orders that have been placed by a customer.*/
	public ArrayList<Order> returnAllOrdersByCustomerID(String customerID){

		//creating a seperate list to store all orders with the same customer id
		ArrayList<Order> allOrdersOfCustomer = new ArrayList<Order>;

		for(Order order : orders){
			if(order.getCustomerID().equals(customerID)){
				allOrdersOfCustomer.add(order);
			}
			return allOrdersOfCustomer;
		}
	}

	// method to load all the products in the txt file into the products list
	public void loadOrders() {
		// create the file that i will load orders from
		File file = new File("orders.txt");

		// clear the list so there are no duplicates
		orders.clear();

		if (file.exists()) {
			try {
				// create scanner
				Scanner scnr = new Scanner(file);
				// assign to line and loop through all lines
				while (scnr.hasNextLine()) {
					String line = scnr.nextLine();

					// split each line into 6 parts for each attribute
					String[] splittedLine = line.split(", ");

					// save the splits in the line in 4 []
					if (splittedLine.length == 4) {
						String productID = splittedLine[0];
						String productName = splittedLine[1];
						double price = Double.parseDouble(splittedLine[2]);
						int quantity = Integer.parseInt(splittedLine[3]);

						// add products
						products.add(new Product(productID, productName, price, quantity));
					}
				}
				scnr.close();
			} catch (Exception e) {
				System.out.println("Error: could not load the products." + e.getMessage());
			}
		} else {
			System.out.println("File products.txt does not exist.");
		}
	}

	// method to save products and write them back into the txt file
	public void saveProducts() {
		try {
			// create a writer
			PrintWriter writer = new PrintWriter("products.txt");

			// loop through products and print them
			for (Product product : products) {
				String line = product.getProductID() + ", " + product.getProductName() + ", " +
						product.getPrice() + ", " + product.getQuantity();
				writer.println(line);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: Could not save the products into products.txt." + e.getMessage());
		}
	}

}