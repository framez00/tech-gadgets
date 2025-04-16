package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
