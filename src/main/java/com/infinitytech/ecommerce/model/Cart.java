package com.infinitytech.ecommerce.model;


import java.util.ArrayList;
import java.util.List;


public class Cart {
   private List<CartItem> items;


   public Cart() {
       this.items = new ArrayList<>();
   }


   public List<CartItem> getItems() { return items; }
   public void setItems(List<CartItem> items) { this.items = items; }


   public double getTotalPrice() {
       return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
   }


   public void addProduct(Product product, int quantity) {
       for (CartItem item : items) {
           if (item.getProduct().getId().equals(product.getId())) {
               item.setQuantity(item.getQuantity() + quantity);
               return;
           }
       }
       items.add(new CartItem(product, quantity));
   }


   public void removeProduct(String productId) {
       items.removeIf(item -> item.getProduct().getId().equals(productId));
   }


   public void clearCart() {
       items.clear();
   }
}


