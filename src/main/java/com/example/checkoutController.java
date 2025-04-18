package com.example;

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
 * This JavaFX controller manages the checkout process in the e-commerce application. 
 * It handles input fields related to shipping and payment information, validates user input, 
 * and simulates placing an order.
 * <p>
 * Important Functions:
 * - placeOrder(): Triggered when the user clicks the "Place Order" button. It validates the input
 *   and shows an alert indicating whether the order was successfully placed. Inputs are taken from
 *   UI fields (TextFields and ChoiceBox). No return value.
 * - showAlert(String message): A utility function that shows an informational popup message to the user.
 *   Input: a message string. Output: none.
 * <p>
 * Important Data Structures:
 * - FXML UI Controls including TextField, ChoiceBox, and Label. These are bound to elements defined
 *   in the corresponding FXML file for the checkout page.
 * <p>
 * Algorithm(s) Used:
 * - Basic field validation (empty checks) to ensure required checkout fields are filled.
 *   Chosen for simplicity and direct user feedback. No payment processing algorithms are implemented.
 */

public class checkoutController {
    @FXML private TextField emailField;
    @FXML private TextField addressField;
    @FXML private TextField cityField;
    @FXML private TextField zipField;
    @FXML private ChoiceBox<String> shippingMethodChoice;
    @FXML private TextField cardNumberField;
    @FXML private TextField expField;
    @FXML private TextField cvvField;
    @FXML private Label orderTotalLabel;

    @FXML
    private void placeOrder() {
        String email = emailField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String zip = zipField.getText();
        String shipping = shippingMethodChoice.getValue();
        String card = cardNumberField.getText();

        if (email.isEmpty() || address.isEmpty() || city.isEmpty() || zip.isEmpty() || card.isEmpty()) {
            showAlert("Please fill in all required fields.");
            return;
        }

        // Process payment (mock)
        System.out.println("Order placed for " + email);
        showAlert("Thank you! Your order has been placed.");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
