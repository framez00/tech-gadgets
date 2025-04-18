import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;

public class CustomerController {
    private ArrayList<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
        loadCustomers();
    }

    //method to load all the customers in the txt file into the customer list
    public void loadCustomers(){
        //create the file that i will load products from
        File file = new File("customers.txt");

        //clear the list so there are no duplicates
        customers.clear();

        if(file.exists()){
            try{
                //create scanner
                Scanner scnr = new Scanner(file);
                //assign to line and loop trhough all lines
                while(scnr.hasNextLine()){
                    String line = scnr.nextLine();

                    //split each line into 10 parts for each attribute
                    String[]splittedLine = line.split(", ");

                    //save the splits in the line in 10 []
                    if(splittedLine.length == 10){
                        String userID = splittedLine[0];
                        String firstName = splittedLine[1];
                        String lastName = splittedLine[2];
                        String dob = splittedLine[3];
                        String email = splittedLine[4];
                        String street = splittedLine[5];
                        String city = splittedLine[6];
                        String state = splittedLine[7];
                        int zip = Integer.parseInt(splittedLine[8]);
                        String phoneNumber = splittedLine[9];
                        
                        //add customers
                        customers.add(new Customer(userID, firstName, lastName, dob, email, street, city, state, zip, phoneNumber));
                    }
                }
                scnr.close();
            }catch(Exception e){
                System.out.println("Error: could not load the customers." + e.getMessage());
            }
        }else{
            System.out.println("File customers.txt does not exist.");
        }
    }

    //method to save customers and write them back into the txt file
    public void saveCustomers(){
        try{
            //create a writer
            PrintWriter writer = new PrintWriter("customers.txt");
    
            //loop through customers and print them
            for(Customer customer : customers){
                String line = customer.getUserID() + ", " + customer.getFirstName() + ", " + customer.getLastName() + ", " + customer.getDob() + ", " + customer.getEmail() + 
                              ", " + customer.getStreet() + ", " + customer.getCity() + ", " + customer.getState() + ", " + customer.getZip() + ", " +  customer.getPhoneNumber();
                writer.println(line);
            }
            writer.close();
        }catch (Exception e){
            System.out.println("Error: Could not save the customer into customers.txt." + e.getMessage());
        }
    }

    public void addCustomer(Customer customer, String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                System.out.printf("Email %s already exists.\n", email);
                return;
            }
        }
        customers.add(customer);
    }

    public void getCustomerInformation(String userID) {
    for (Customer customer : customers) {
        if (customer.getUserID().equals(userID)) {
            System.out.println("CustomerID: " + customer.getUserID() + ", Name: " + customer.getFirstName() + " " + customer.getLastName() + ", DOB: " + customer.getDob() + ", " +
                               "Email: " + customer.getEmail() + ", Address " + customer.getStreet() + " " + customer.getCity() + " " + customer.getState() + " " + customer.getZip() + 
                               ", Phone Number: " + customer.getPhoneNumber());
            return;
        }
    }
    System.out.println("Customer does not exist.");
    }

    public boolean updateCustomerDetails(String userID, String email, String newStreet, String newCity, String newState, int newZip, String newPhoneNumber) {
        for(Customer customer : customers){
            if(customer.getUserID().equals(userID)){
                if(email != null){customer.setEmail(email);}
                if(newStreet != null){customer.setStreet(newStreet);}
                if(newCity != null){customer.setCity(newCity);}
                if(newZip != 0){customer.setZip(newZip);}
                if(newPhoneNumber != null){customer.setPhoneNumber(newPhoneNumber);}
                return true;
            }
        }
        return false;
    }

    public boolean removeCustomer(String userID) {
        //go through the list and loop
        for(Customer customer : customers){

            //if customerID is found, remove
            if(customer.getUserID().equals(userID)){
                customers.remove(customer);
                System.out.println("Customer with userID " + userID + " has been removed.");
                return true;
            }
        }
        //if not, it doesnt exist
        System.out.println("Customer does not exist.");
        return false;
    }

    public boolean doesCustomerExist(String userID) {
        for(Customer customer : customers){
            if(customer.getUserID().equals(userID)){
                System.out.println("Customer exists.");
                return true;
            }
        }
        System.out.println("Customer does not exist.");
        return false;
    }

    //list all customers
    public ArrayList<Customer>listAllCustomers(){
        for(Customer customer : customers){
            System.out.println(customer.getUserID() + ", " + customer.getFirstName() + ", " +
                               customer.getLastName() + ", " + customer.getEmail());
        }
        return customers;
    }
}
