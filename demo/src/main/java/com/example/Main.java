package com.example;

// JavaFX E-commerce Website Example

// Importing necessary JavaFX libraries
import javafx.application.Application;
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

    // The start method is the main entry point for all JavaFX applications
    @Override
    public void start(Stage primaryStage) {
        // Root layout using BorderPane
        BorderPane root = new BorderPane();

        // Top Navigation Bar
        HBox navBar = new HBox(20);
        navBar.setPadding(new Insets(50, 5, 10, 5));
        navBar.setStyle("-fx-background-color:rgb(0, 0, 0);");

        Button homeButton = new Button("Home");
        Button categoriesButton = new Button("Categories");
        Button cartButton = new Button("Cart");
        TextField searchField = new TextField();
        searchField.setPromptText("Search products...");

        navBar.getChildren().addAll(homeButton, categoriesButton, cartButton, searchField);
        navBar.setAlignment(Pos.CENTER);
        root.setBottom(navBar);

        // Center Product Grid
        GridPane productGrid = new GridPane();
        productGrid.setPadding(new Insets(20));
        productGrid.setHgap(20);
        productGrid.setVgap(20);
        productGrid.setAlignment(Pos.CENTER);

        // Adding sample products
        for (int i = 0; i < 6; i++) {
            VBox productCard = new VBox(10);
            productCard.setPadding(new Insets(10));
            productCard.setStyle("-fx-border-color: #bdc3c7; -fx-border-width: 1; -fx-background-color: #ecf0f1;");
            productCard.setAlignment(Pos.CENTER);

            Label productName = new Label("Product " + (i + 1));
            Button buyButton = new Button("Buy Now");

            productCard.getChildren().addAll(productName, buyButton);
            productGrid.add(productCard, i % 3, i / 3);
        }

        root.setCenter(productGrid);

        // Footer
        HBox footer = new HBox();
        footer.setPadding(new Insets(10));
        footer.setAlignment(Pos.CENTER);
        footer.setStyle("-fx-background-color: #2c3e50;");
        Label footerText = new Label("© 2025 E-Commerce Website");
        footerText.setStyle("-fx-text-fill: white;");
        footer.getChildren().add(footerText);
        root.setBottom(footer);

        // Setting the scene
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
