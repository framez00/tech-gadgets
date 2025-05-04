import java.util.Scanner;

public class PaymentService {
    private Scanner input = new Scanner(System.in);

    public boolean processPayment() {
        System.out.print("Enter your full name: "); 
        String name = input.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("its empty");
            return false;
        }

        System.out.print("Enter your 16-digit credit card number: ");
        String cardNumber = input.nextLine().replaceAll("\\s+", "");

        if (!cardNumber.matches("\\d{16}")) {
            System.out.println("Invalid card number ");
            return false;
        }

        System.out.print("Enter your 3 or 4-digit security code: ");
        String securityCode = input.nextLine();

        if (!securityCode.matches("\\d{3,4}")) {
            System.out.println("Invalid security code");
            return false;
        }

        System.out.print("Enter expiration date (MM/YY): ");
        String expDate = input.nextLine();

        if (!expDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            System.out.println("Invalid expiration date format. Must be MM/YY.");
            return false;
        }

        

        return true;
    }
}
