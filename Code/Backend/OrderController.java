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
                System.out.println("Order with orderID " + orderID + " has been removed.");
            }
        }
        //if not, it doesnt exist
        System.out.println("Order does not exist.");
	}

	public ArrayList<Order> listAllOrders() {
		for(Order order : orders){
            System.out.println(order.getOrderID() + ", " + order.getCustomerID() + ", "  + order.getPrice() + ", " + 
            				   order.getOrderDate() + ", " + order.getStatus() + ", " + order.getProductList());
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
		ArrayList<Order> allOrdersOfCustomer = new ArrayList<Order>();

		for(Order order : orders){
			if(order.getCustomerID().equals(customerID)){
				allOrdersOfCustomer.add(order);
			}
		}
		return allOrdersOfCustomer;
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

					// save the splits in the line in 6 []
					if (splittedLine.length == 6) {
						//assign each index to its parameter
						String orderID = splittedLine[0].trim();
						String customerID = splittedLine[1].trim();
						double price = Double.parseDouble(splittedLine[2]);
						String orderDate = splittedLine[3].trim();
						String status = splittedLine[4].trim();

						//now im splitting index 5 and by each / to create product array
						String productsLine = splittedLine[5].trim();
						String[]productsSplit = productsLine.split("/");
						ArrayList<Product> productList = new ArrayList<>();

						//now i loop, and split the information of the products in 4 pieces
						for(int i = 0; i <= productsSplit.length; i++){
							String productInfo = productsSplit[i];
							String[]productArray = productInfo.split(":");
							if(productArray.length == 4){
								String productID = productArray[0].trim();
								String productName = productArray[1].trim();
								double cost = Double.parseDouble(productArray[2]);
								int amount = Integer.parseInt(productArray[3]); 

								productList.add(new Product(productID, productName, cost, amount));						
							}
						}

						orders.add(new Order(orderID, customerID, price, orderDate, status, productList));

					}
				}
				scnr.close();
			} catch (Exception e) {
				System.out.println("Error: could not load the order." + e.getMessage());
			}
		} else {
			System.out.println("File order.txt does not exist.");
		} 
	}

	// method to save order and write them back into the txt file
	public void saveOrder() {
		try {
			// create a writer
			PrintWriter writer = new PrintWriter("order.txt");

			// loop through orders and print them
			for (Order order : orders) {
				String line = order.getOrderID() + ", " + order.getCustomerID() + ", " +
						order.getPrice() + ", " + order.getOrderDate() + ", " + order.getStatus() + ", " + order.getProductList();
				writer.println(line);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: Could not save the products into products.txt." + e.getMessage());
		}
	}

}