package com.infinitytech.ecommerce.controller;


import com.infinitytech.ecommerce.model.CartItem;
import com.infinitytech.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cart")
public class CartController {


   @Autowired
   private CartService cartService;


   @PostMapping("/add")
   public ResponseEntity<String> addProduct(@RequestParam String productName) {
       if (cartService.addProductToCart(productName)) {
           return ResponseEntity.ok("Product added");
       }
       return ResponseEntity.status(404).body("NOT Ffound");
   }


   @DeleteMapping("/remove")
   public ResponseEntity<String> removeProduct(@RequestParam String productName) {
       if (cartService.removeProductFromCart(productName)) {
           return ResponseEntity.ok("Product removed");
       }
       return ResponseEntity.status(404).body("NOT FOUND");
   }


   @DeleteMapping("/clear")
   public ResponseEntity<String> clearCart() {
       cartService.clearCart();
       return ResponseEntity.ok("Cart emptied");
   }


   @GetMapping
   public ResponseEntity<Map<String, Object>> getCart() {
       List<CartItem> items = cartService.getCartItems();
       double total = cartService.getTotalPrice();


       Map<String, Object> response = new HashMap<>();
       response.put("items in cart", items);
       response.put("Sub-total", total);
       response.put("count", items.size());


       return ResponseEntity.ok(response);
   }
}


//curl -X POST "http://localhost:8080/cart/add?productName=NanoPhone"


//curl -X POST "http://localhost:8080/cart/add?productName=Blue%20Yeti%20Professional%20Multi-Pattern%20USB%20Condenser%20Microphone"


//curl -X POST "http://localhost:8080/cart/add?productName=Apple%20Watch%20Series%2010%20%28GPS%29%2046mm%20Aluminum%20Case%20with%20Black%20Sport%20Band%20-%20M/L%20-%20Jet%20Black"


//curl -X GET "http://localhost:8080/cart"


//curl -X DELETE "http://localhost:8080/cart/remove?productName=NanoPhone"


//curl -X DELETE "http://localhost:8080/cart/clear"
