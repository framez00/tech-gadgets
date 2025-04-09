public class Customer {

    private String userID;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer(String userID, String firstName, String lastName, LocalDate DOB, String email, String address, String phoneNumber) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname(){
        return lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setFirstName(String firstName){
        return firstName;
    }

    public void setLastName(String lastName){
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
