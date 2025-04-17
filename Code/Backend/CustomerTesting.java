public class CustomerTesting{
	public static void main(String[] args){
		CustomerController cntr = new CustomerController();

		// Load existing products from file
        cntr.loadCustomers();
        System.out.println("Customer loaded from file:");
        cntr.listAllCustomers();

        // add customers
        System.out.println("\nAdding a new customer:");
        Customer newCustomer = new Customer("C04", "Tanjiro", "Kamado", "2000-10-26", "tanjiro.kamado@email.com", "19283 Elm Street", "Los Angeles", "CA", 91326, "8187469036");
        cntr.addCustomer(newCustomer, "tanjiro.kamado@email.com");
        cntr.saveCustomers();  // Save to file
        System.out.println("After adding new customer:");
        cntr.listAllCustomers();

        System.out.println("\nAdding a new customer:");
        newCustomer = new Customer("C05", "Zenitsu", "Agatsuma", "2000-10-26", "zenitsu.agatsuma@email.com", "19283 Elm Street", "Los Angeles", "CA", 91326, "8187469036");
        cntr.addCustomer(newCustomer, "john.doe@email.com");
        cntr.saveCustomers();  // Save to file
        System.out.println("After adding new customer:");
        cntr.listAllCustomers();

        //check if customer exists
        System.out.println("\nDoes customer with id C02 exist?");
        boolean exists = cntr.doesCustomerExist("C02");
        System.out.println(exists ? "Yes" : "No");

        //remove customer
        System.out.println("\nRemoving customer C02:");
        cntr.removeCustomer("C02");
        cntr.saveCustomers();  // Save updated list
        cntr.listAllCustomers();

        //check for removed customer
        System.out.println("\nDoes customer with id C02 exist?");
        exists = cntr.doesCustomerExist("C02");
        System.out.println(exists ? "Yes" : "No");

	}
}