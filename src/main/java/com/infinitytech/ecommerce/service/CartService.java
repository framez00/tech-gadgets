package com.infinitytech.ecommerce.service;


import com.infinitytech.ecommerce.model.Cart;
import com.infinitytech.ecommerce.model.CartItem;
import com.infinitytech.ecommerce.model.Product;
import org.springframework.stereotype.Service;


import java.io.*;
import java.util.List;


@Service
public class CartService {


   private static final String CART_FILE_PATH = "src/main/resources/cart.txt";
   private final Cart cart = new Cart();
   private final ProductService productService;


   public CartService(ProductService productService) {
       this.productService = productService;
       loadCartFromFile(); // Initialization logic here instead of @PostConstruct
   }


   private void loadCartFromFile() {
       cart.clearCart();
       try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE_PATH))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(",", 6); // id,name,category,desc,price,qty
               if (parts.length == 6) {
                   Product product = new Product(
                       parts[0].trim(),     // id
                       parts[1].trim(),     // name
                       parts[2].trim(),     // category
                       parts[3].trim(),     // description
                       Double.parseDouble(parts[4].trim()) // price
                   );
                   int qty = Integer.parseInt(parts[5].trim());
                   cart.addProduct(product, qty);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }


   private void saveCartToFile() {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE_PATH))) {
           for (CartItem item : cart.getItems()) {
               Product p = item.getProduct();
               writer.write(String.join(",", p.getId(), p.getName(), p.getCategory(),
                       p.getDescription(), String.valueOf(p.getPrice()), String.valueOf(item.getQuantity())));
               writer.newLine();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }


   public boolean addProductToCart(String productName) {
       Product product = productService.getProductByName(productName);
       if (product != null) {
           cart.addProduct(product, 1);
           saveCartToFile();
           return true;
       }
       return false;
   }


   public boolean removeProductFromCart(String productName) {
       Product product = productService.getProductByName(productName);
       if (product != null) {
           cart.removeProduct(product.getId());
           saveCartToFile();
           return true;
       }
       return false;
   }


   public void clearCart() {
       cart.clearCart();
       saveCartToFile();
   }


   public List<CartItem> getCartItems() {
       return cart.getItems();
   }


   public double getTotalPrice() {
       return cart.getTotalPrice();
   }
}


//curl -X POST "http://localhost:8080/cart/add?productName=NanoPhone"
//curl -X POST "http://localhost:8080/cart/add?productName=Blue%20Yeti%20Professional%20Multi-Pattern%20USB%20Condenser%20Microphone"
//curl -X POST "http://localhost:8080/cart/add?productName=Apple%20Watch%20Series%2010%20%28GPS%29%2046mm%20Aluminum%20Case%20with%20Black%20Sport%20Band%20-%20M/L%20-%20Jet%20Black"


//curl -X GET "http://localhost:8080/cart" -H "Accept: application/json"


//curl -X DELETE "http://localhost:8080/cart/remove?productName=NanoPhone"


//curl -X DELETE "http://localhost:8080/cart/clear"
