package com.example;

// JavaFX E-commerce Website Example

// Importing necessary JavaFX libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

// Main class extending Application class to launch JavaFX application
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/primary.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("JavaFX E-commerce Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // The main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * Explanation of Layouts:
 * 
 * 1. BorderPane:
 * - Used as the root layout to divide the window into Top, Center, and Bottom
 * sections.
 * 
 * 2. HBox (Navigation Bar & Footer):
 * - Top: Contains navigation buttons and a search bar.
 * - Bottom: Displays footer text.
 * 
 * 3. GridPane (Product Grid):
 * - Displays products in a grid format with 3 columns.
 * 
 * 4. VBox (Product Cards):
 * - Each product card includes a product name and a "Buy Now" button.
 * 
 * The design includes basic styling and structure for an e-commerce website.
 */
