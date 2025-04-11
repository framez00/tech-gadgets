import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String userID, String firstName, String lastName, LocalDate DOB, String email, String address, String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return false;
            }
        }
        customers.add(new Customer(userId, firstName, lastName, DOB, email, address, phoneNumber));
        return true;
    }

    public Customer getCustomer(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public boolean updateCustomerDetails(String email, String newAddress, String newPhoneNumber) {
        Customer customer = getCustomer(email);
        if (customer != null) {
            customer.setAddress(newAddress);
            customer.setPhoneNumber(newPhoneNumber);
            return true;
        }
        return false;
    }

    public boolean removeCustomer(String email) {
        Customer customer = getCustomer(email);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public boolean isCustomerExist(String email) {
        return getCustomer(email) != null;
    }
}
