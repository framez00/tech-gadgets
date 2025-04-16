package com.example;
/*
Put header here


 */

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

public class FXMLController implements Initializable {

    @FXML
    private Label cartCountLabel;
    
    @FXML 
    private VBox cartPopup;
    

    private int cartCount = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartCountLabel.setText(String.valueOf(cartCount));
    }

    @FXML
    private void addToCart(ActionEvent event) {
        cartCount++;
        cartCountLabel.setText(String.valueOf(cartCount));
    }

    //when mouse hovers over shopping cart image, cart summary appears
    @FXML
    private void showCartPopup(MouseEvent event) {
        cartPopup.setVisible(true);
    }

    //when mouse exits, cart popup disappears
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


}
