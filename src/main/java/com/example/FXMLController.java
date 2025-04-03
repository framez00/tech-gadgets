package com.example;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    @FXML
    private Label cartCountLabel;

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

}
