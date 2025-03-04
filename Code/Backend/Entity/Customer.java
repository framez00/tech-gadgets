public class Customer {

    private String userID;
    private String name;
    private LocalDate DOB;
    private String email;
    private String address;

    public Customer(String name, LocalDate DOB, String email, String address) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
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
    public void setAddress(String address) {
        this.address = address;
    }
}
