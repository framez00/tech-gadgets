import java.util.ArrayList;
public class OrderTesting{
	public static void main(String[] args){
		OrderController cntr = new OrderController();

		// Load existing products from file
        cntr.loadOrders();
        System.out.println("Order loaded from file:");
        cntr.listAllOrders();

        // add customers
        System.out.println("\nAdding a new Order: Keyboard");
        ArrayList<Product> products = new ArrayList<>();
		products.add(new Product("P01", "Keyboard", 15.00, 1));
		products.add(new Product("P02", "Headphones", 15.00, 1));
        Order newOrder = new Order("O04", "C03", 30.00, "03-10-2025", "delivered", products);
        cntr.addOrder(newOrder);
        cntr.saveOrder();  // Save to file
        System.out.println("After adding new order:");
        cntr.listAllOrders();

        //check if order exists
        System.out.println("\nDoes order with id O01 exist?");
        boolean exists = cntr.doesOrderExist("O02");
        System.out.println(exists ? "Yes" : "No");

        //remove order
        System.out.println("\nRemoving order O01:");
        cntr.removeOrder("O01");
        cntr.saveOrder();  // Save updated list
        cntr.listAllOrders();

        //check for removed order
        System.out.println("\nDoes customer with custumerID C05 exist?");
        exists = cntr.doesOrderExist("C02");
        System.out.println(exists ? "Yes" : "No");

        //get all orders of customer C01
        System.out.println("\nGet all orders of customer C03:");
        cntr.returnAllOrdersByCustomerID("C03");
	}
}