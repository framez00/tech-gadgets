public class CustomerTesting{
	public static void main(String[] args){
		CustomerController cntr = new CustomerController();

		// Load existing products from file
        cntr.loadCustomers();
        System.out.println("Customer loaded from file:");
        cntr.listAllCustomers();

        // add customers
        System.out.println("\nAdding a new customer:");
        Customer newCustomer = new Customer("C04", "John", "Doe", "2000-10-26", "john.doe@email.com", "19283 Elm Street", "Los Angeles", "CA", 91326, "8187469036");
        cntr.addCustomer(newCustomer, "john.doe@email.com");
        cntr.saveCustomers();  // Save to file
        System.out.println("After adding new customer:");
        cntr.listAllCustomers();

        //check if customer exists
        System.out.println("\nDoes customer with id 02 exist?");
        boolean exists = cntr.doesCustomerExist("02");
        System.out.println(exists ? "Yes" : "No");

        //remove customer
        System.out.println("\nRemoving customer 02:");
        cntr.removeCustomer("02");
        cntr.saveCustomers();  // Save updated list
        cntr.listAllCustomers();

        //check for removed customer
        System.out.println("\nDoes customer with id 02 exist?");
        exists = cntr.doesCustomerExist("02");
        System.out.println(exists ? "Yes" : "No");

	}
}