package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import Code.Backend.CartService;
import Code.Backend.Customer;
import Code.Backend.CustomerController;
import Code.Backend.Order;
import Code.Backend.OrderController;
import Code.Backend.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class Name: checkoutController
 * <p>
 * Date: April 15, 2025
 * <p>
 * Programmer:Mercedes Tamayo
 * <p>
 * Description:
 * This JavaFX controller manages the checkout process in the e-commerce
 * application.
 * It handles input fields related to shipping and payment information,
 * validates user input,
 * and simulates placing an order.
 * <p>
 * Important Functions:
 * - placeOrder(): Triggered when the user clicks the "Place Order" button. It
 * validates the input
 * and shows an alert indicating whether the order was successfully placed.
 * Inputs are taken from
 * UI fields (TextFields and ChoiceBox). No return value.
 * - showAlert(String message): A utility function that shows an informational
 * popup message to the user.
 * Input: a message string. Output: none.
 * <p>
 * Important Data Structures:
 * - FXML UI Controls including TextField, ChoiceBox, and Label. These are bound
 * to elements defined
 * in the corresponding FXML file for the checkout page.
 * <p>
 * Algorithm(s) Used:
 * - Basic field validation (empty checks) to ensure required checkout fields
 * are filled.
 * Chosen for simplicity and direct user feedback. No payment processing
 * algorithms are implemented.
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import Code.Backend.Customer;
import Code.Backend.CustomerController;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class checkoutController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField zipField;
    @FXML
    private ChoiceBox<String> shippingMethodChoice;
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField expField;
    @FXML
    private TextField cvvField;
    @FXML
    private Label orderTotalLabel;
    @FXML
    private TextField stateField;

    @FXML
    private void placeOrder() {
        // Collect form input
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String street = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText(); // Make sure this field is in your FXML
        String zipText = zipField.getText();

        // Validate form fields
        if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || phone.isEmpty()
                || email.isEmpty() || street.isEmpty() || city.isEmpty()
                || state.isEmpty() || zipText.isEmpty()) {
            showAlert("Please fill in all required fields.");
            return;
        }

        int zip;
        try {
            zip = Integer.parseInt(zipText);
        } catch (NumberFormatException e) {
            showAlert("ZIP code must be a number.");
            return;
        }

        // Generate IDs
        String customerId = UUID.randomUUID().toString();
        String orderId;
        String orderDate = java.time.LocalDate.now().toString();
        String status = "Placed";

        // Create and save Customer
        Customer customer = new Customer(customerId, firstName, lastName, dob,
                email, street, city, state, zip, phone);
        CustomerController customerController = new CustomerController();
        customerController.addCustomer(customer, email);
        customerController.saveCustomers();

        // Load cart items
        //CartService cartService = new CartService();
        CartService cartService = CartService.getInstance();

        ArrayList<Product> cartItems = new ArrayList<>(cartService.getCartItems());
        if (cartItems.isEmpty()) {
            showAlert("Your cart is empty.");
            return;
        }

        // Calculate total price
        double total = 0;
        for (Product p : cartItems) {
            total += p.getPrice() * p.getQuantity();
        }

        // Create and save Order
        OrderController orderController = new OrderController();
        orderId = orderController.createOrderID();

        Order order = new Order(orderId, customerId, total, orderDate, status, cartItems);
        orderController.addOrder(order);
        orderController.saveOrder();

        // Clear the cart
        cartService.clearCart();

        // Success message
        showAlert("Order placed successfully!");
    }

    private String generateCustomerID() {
        int count = 1;
        File file = new File("customers.txt");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    count++;
                }
            } catch (IOException e) {
                System.out.println("Error reading customers.txt: " + e.getMessage());
            }
        }
        return "C" + String.format("%02d", count);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goBackToCatalog(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/primary.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
