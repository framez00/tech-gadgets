public class Customer {

    private String userID;
    private String name;
    private LocalDate DOB;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer(String name, LocalDate DOB, String email, String address) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
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
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
