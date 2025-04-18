import java.time.LocalDate;

/**
 * (a) Class Name: Customer
 * 
 * (b) Date: April 16, 2025
 * 
 * (c) Programmer: Fahim Ramez
 * 
 * (d) Description:
 * This class represents a customer in a system that stores user details such as 
 * name, date of birth, contact information, and address.
 * 
 * (e) Important Functions:
 * - Constructor: Initializes a new customer object with the provided personal details.
 * - Getters/Setters: Used to retrieve and update each field. Input values are either
 *   Strings or integers, and output values are the corresponding field values.
 * 
 * (f) Data Structures:
 * - Uses only primitive data types and Strings to store customer information.
 *   No advanced data structures are used in this class.
 * 
 * (g) Algorithms:
 * - No algorithms are implemented in this class; it only acts as a data container
 *   with standard getter and setter methods.
 */

public class Customer {

    private String userID;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;

    public Customer(String userID, String firstName, String lastName, String dob, String email, String street, String city, String state, int zip, String phoneNumber) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        
    }

    //Getters and setters ============================================================

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob){
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //=======================================================================================

}
