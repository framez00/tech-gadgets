package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FXMLController implements Initializable {

    @FXML
    private Label cartCountLabel;

    @FXML
    private VBox cartPopup;

    private int cartCount = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (cartCountLabel != null) {
            cartCountLabel.setText(String.valueOf(cartCount));
        }
    }

    @FXML
    private void addToCart(ActionEvent event) {
        cartCount++;
        cartCountLabel.setText(String.valueOf(cartCount));
    }

    // when mouse hovers over shopping cart image, cart summary appears
    @FXML
    private void showCartPopup(MouseEvent event) {
        cartPopup.setVisible(true);
    }

    // when mouse exits, cart popup disappears
    @FXML
    private void hideCartPopup(MouseEvent event) {
        cartPopup.setVisible(false);
    }

    @FXML
    private void goToCheckout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/checkout.fxml"));
            Parent checkoutRoot = loader.load();

            Stage stage = (Stage) cartPopup.getScene().getWindow(); // Get current window
            Scene checkoutScene = new Scene(checkoutRoot);
            stage.setScene(checkoutScene);
            stage.setTitle("Checkout");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    private void openProduct1(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product1.fxml");
    }

    @FXML
    private void openProduct2(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product2.fxml");
    }

    @FXML
    private void openProduct3(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product3.fxml");
    }

    @FXML
    private void openProduct4(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product4.fxml");
    }

    @FXML
    private void openProduct5(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product5.fxml");
    }

    @FXML
    private void openProduct6(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product6.fxml");
    }

    @FXML
    private void openProduct7(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product7.fxml");
    }

    @FXML
    private void openProduct8(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product8.fxml");
    }

    @FXML
    private void openProduct9(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product9.fxml");
    }

    @FXML
    private void openProduct10(MouseEvent event) throws IOException {
        loadProductPage(event, "/fxml/product10.fxml");
    }

    private void loadProductPage(MouseEvent event, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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
