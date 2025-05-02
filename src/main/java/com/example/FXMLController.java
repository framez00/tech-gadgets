/**
 * Class Name: FXMLController
 * <p>
 * Date: April 15, 2025
 * <p>
 * Programmer: Mercedes Tamayo & Vardges Gasparyan
 * <p>
 * Description:
 * It handles product navigation,cart updates, and transitions to the checkout
 * page.
 * <p>
 * Important Functions:
 * - toggleCartPopup(MouseEvent): Toggles cart summary popup visibility. Input:
 * mouse click. Output: none.
 * - goToCheckout(): Loads the checkout page scene. Input: none. Output: new
 * scene set on the same stage.
 * - openProductX(MouseEvent): Loads a specific product page (1 through 10).
 * Input: mouse click. Output: scene transition.
 * <p>
 * Important Data Structures:
 * - VBox cartPopup: UI container for showing a brief cart summary.
 * - Label cartCountLabel: UI label displaying number of items in the cart.
 * - Integer cartCount: tracks the number of items added.
 * - Boolean isCartPopupVisible: tracks cart popup state.
 * <p>
 * Algorithms:
 * - Scene switching for product pages uses a reusable helper method
 * `loadProductPage()` to avoid redundancy,
 * improving maintainability and reducing code duplication.
 */

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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Code.Backend.ProductService;
import Code.Backend.OrderController;
import Code.Backend.Product;
import Code.Backend.ProductService;

import java.util.List;

public class FXMLController implements Initializable {

    @FXML
    private Label cartCountLabel;

    @FXML
    private VBox cartPopup;

    private int cartCount = 0;

    private boolean isCartPopupVisible = false;

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

    // allows cart summary popup to be visible when shopping cart image is clicked
    @FXML
    private void toggleCartPopup(MouseEvent event) {
        isCartPopupVisible = !isCartPopupVisible;
        cartPopup.setVisible(isCartPopupVisible);
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

    @FXML
    private TextField searchField;

    @FXML
    private GridPane productGrid;

    private final ProductService productService = new ProductService();

    @FXML
    public void handleSearch() {
        String keyword = searchField.getText();
        List<Product> results = productService.searchProducts(keyword);
        productGrid.getChildren().clear();

        int col = 0;
        int row = 0;

        for (Product p : results) {
            VBox card = new VBox(5);
            card.setStyle("-fx-padding: 10; -fx-border-color: #ccc; -fx-border-radius: 8;");
            card.setPrefWidth(160);

            Label name = new Label(p.getProductName());
            Label price = new Label("Price: $" + p.getPrice());
            Button add = new Button("Add to Cart");
            add.setOnAction(this::addToCart);

            card.getChildren().addAll(name, price, add);
            productGrid.add(card, col, row);

            col++;
            if (col > 4) {
                col = 0;
                row++;
            }
        }
    }

    private final OrderController orderController = new OrderController();

    @FXML
    private void showTotalSales() {
        double totalSales = orderController.trackSales();
        int totalOrders = orderController.countOrder();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total Sales");
        alert.setHeaderText("Sales Summary");
        alert.setContentText("Total Orders: " + totalOrders + "\nTotal Sales: $" + totalSales);
        alert.showAndWait();
    }

}