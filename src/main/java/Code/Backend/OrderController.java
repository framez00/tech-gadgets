package Code.Backend;

import Code.Backend.Order;

import Code.Backend.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrderController {
	private ArrayList<Order> orders;

	public OrderController() {
		this.orders = new ArrayList<>();
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void removeOrder(String orderID) {
		// loop down
		for (int i = orders.size() - 1; i >= 0; i--) {
			if (orders.get(i).getOrderID().equals(orderID)) {
				orders.remove(i);
				System.out.println("Order with orderID " + orderID + " has been removed.");
				return;
			}
		}
		System.out.println("Order with orderID " + orderID + " not found.");
	}

	public ArrayList<Order> listAllOrders() {
		for (Order order : orders) {
			System.out.println(order.getOrderID() + ", " + order.getCustomerID() + ", " + order.getPrice() + ", " +
					order.getOrderDate() + ", " + order.getStatus() + ", " + order.getProductList());
		}
		return orders;
	}

	public boolean doesOrderExist(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID)) {
				System.out.println("Order exists.");
				return true;
			}
		}
		System.out.println("Order does not exist.");
		return false;
	}

	/*
	 * this method searches through the orders list and looks for a customer id, to
	 * list
	 * all orders that have been placed by a customer.
	 */
	public void returnAllOrdersByCustomerID(String customerID) {
		for (Order order : orders) {
			if (order.getCustomerID().equals(customerID)) {
				System.out.println(order);
			}
		}
	}

	// method to load all the products in the txt file into the products list
	public void loadOrders() {
		// create the file that i will load orders from
		File file = new File("orders.txt");

		// clear the list so there are no duplicates
		// orders.clear();

		if (file.exists()) {
			try {
				// create scanner
				Scanner scnr = new Scanner(file);
				// assign to line and loop through all lines
				while (scnr.hasNextLine()) {
					String line = scnr.nextLine().trim();

					// split each line into 6 parts for each attribute
					String[] splittedLine = line.split(", ");

					// save the splits in the line in 6 []
					if (splittedLine.length == 6) {
						// assign each index to its parameter
						String orderID = splittedLine[0].trim();
						String customerID = splittedLine[1].trim();
						double price = Double.parseDouble(splittedLine[2].trim());
						String orderDate = splittedLine[3].trim();
						String status = splittedLine[4].trim();

						// now im splitting index 5 and by each / to create product array
						String productsLine = splittedLine[5].trim();
						String[] productsSplit = productsLine.split("/");
						ArrayList<Product> productList = new ArrayList<>();

						// now i loop, and split the information of the products in 4 pieces
						for (int i = 0; i < productsSplit.length; i++) {
							String productInfo = productsSplit[i];
							String[] productArray = productInfo.split(":");
							if (productArray.length == 4) {
								String productID = productArray[0].trim();
								String productName = productArray[1].trim();
								double cost = Double.parseDouble(productArray[2].trim());
								int amount = Integer.parseInt(productArray[3].trim());

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
			System.out.println("File orders.txt does not exist.");
		}
	}

	// method to save order and write them back into the txt file
	public void saveOrder() {
		try {
			// create a writer
			PrintWriter writer = new PrintWriter("orders.txt");

			// loop through orders and print them
			for (Order order : orders) {
				String line = order.getOrderID() + ", " + order.getCustomerID() + ", " +
						order.getPrice() + ", " + order.getOrderDate() + ", " + order.getStatus() + ", "
						+ order.getProductList();
				writer.println(line);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: Could not save the products into products.txt." + e.getMessage());
		}
	}

	public String createOrderID() {
		return "O" + (orders.size() + 1);
	}

	public boolean updateOrderStatus(String orderID, String status) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID)) {
				order.setStatus(status);
				saveOrder();
				return true;
			}
		}
		return false;
	}

	public void pullProductsFromCartIntoOrder(String customerID) {
		// create the file that i will load products from
		File file = new File("cart.txt");

		ArrayList<Product> products = new ArrayList<>();

		if (file.exists()) {
			try {
				// create scanner
				Scanner scnr = new Scanner(file);
				// assign to line and loop trhough all lines
				while (scnr.hasNextLine()) {
					String line = scnr.nextLine();

					// split each line into 4 parts for each attribute
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
				System.out.println("Error: could not load the cart." + e.getMessage());
			}

			if (products.isEmpty()) {
				System.out.println("Cart is empty.");
				return;
			}

			// Creating the order after pullig the items from the cart
			double price = 0;
			for (Product product : products) {
				price = price + (product.getPrice() * product.getQuantity());
			}

			String orderID = createOrderID();
			String orderDate = java.time.LocalDate.now().toString();
			String status = "pending";

			Order order = new Order(orderID, customerID, price, orderDate, status, products);
			orders.add(order);

			System.out.printf("The order with order ID %s was successfully placed\n", orderID);
		} else {
			System.out.println("File carts.txt does not exist.");
		}
	}

	public double trackSales(){
		double total = 0.0;

		for(Order order : orders){
			total += order.getPrice();
		}

		return total;
	}

	public int countOrder(){
		int count = 0;
		
		for(Order order : orders){
			count++;
		}

		return count;
	}

}