package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Code.Backend.Customer;
import Code.Backend.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private void placeOrder() {
        // Get user input from form
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String street = addressField.getText();
        String city = cityField.getText();
        String zipText = zipField.getText();

        // Validate required fields
        if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || phone.isEmpty()
                || email.isEmpty() || street.isEmpty() || city.isEmpty() || zipText.isEmpty()) {
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

        String userID = generateCustomerID();
        String state = "CA"; // Hardcoded for now — can make this a dropdown later

        Customer customer = new Customer(userID, firstName, lastName, dob, email, street, city, state, zip, phone);

        CustomerController customerController = new CustomerController();
        customerController.addCustomer(customer, email);
        customerController.saveCustomers();

        showAlert("Order placed. Customer saved.");
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
}
