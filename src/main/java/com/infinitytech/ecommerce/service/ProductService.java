package com.infinitytech.ecommerce.service;

<<<<<<< HEAD

import com.infinitytech.ecommerce.model.Product;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
=======
import com.infinitytech.ecommerce.model.Product;
import org.springframework.stereotype.Service;

>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD

@Service
public class ProductService {


   private final List<Product> productList = new ArrayList<>();


   public ProductService() {
       try (InputStream is = getClass().getClassLoader().getResourceAsStream("products.txt")) {
           if (is == null) {
               System.out.println("products.txt not found ");
               return;
           }


           BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(",", 5);
               if (parts.length == 5) {
                   String id = parts[0].trim();
                   String name = parts[1].trim();
                   String category = parts[2].trim();
                   String description = parts[3].trim();
                   double price = Double.parseDouble(parts[4].trim());


                   productList.add(new Product(id, name, category, description, price));
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


   public List<Product> getAllProducts() {
       return productList;
   }


   public Product getProductByName(String name) {
       return productList.stream()
               .filter(p -> p.getName().equalsIgnoreCase(name))
               .findFirst()
               .orElse(null);
   }


   public List<Product> searchProducts(String query) {
       if (query == null || query.isEmpty()) return productList;
       return productList.stream()
               .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase())
                       || p.getCategory().toLowerCase().contains(query.toLowerCase()))
               .collect(Collectors.toList());
   }
=======
@Service
public class ProductService {

    private final List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();

        productList.add(new Product("JVC - Powerful Sound On Ear Headphones - Black", "HeadPhones", 1200.00));
        productList.add(new Product("Sony - Wireless Noise-Canceling Over-the-Ear Headphones - Black", "HeadPhones", 800.00));
        productList.add(new Product("Lenovo - Ideapad 3 15 15.6\" Touch-Screen Laptop - Intel Core i3 - 8GB Memory - 256GB SSD - Abyss Blue", "LapTops", 150.00));
        productList.add(new Product("ASUS - 2-in-1 14\" Touch-Screen Laptop - Intel Core i5 - 8GB Memory - 128GB Solid State Drive - Light Gray", "LapTops", 90.00));
        productList.add(new Product("NanoPhone", "Phones", 200.00));
        productList.add(new Product("iPhone 15 brings you Dynamic Island, a 48MP Main camera, and USB-C—all in a durable color-infused glass and aluminum design", "Phones", 60.00));
        productList.add(new Product("Blue Yeti Professional Multi-Pattern USB Condenser Microphone", "MicroPhones", 85.00));
        productList.add(new Product("Apple Watch Series 10 (GPS) 46mm Aluminum Case with Black Sport Band - M/L - Jet Black", "SmartWatches", 145.00));
        productList.add(new Product("SM7B Cardioid Dynamic Vocal Microphone", "MicroPhones", 235.00));
        productList.add(new Product("Garmin - vívoactive 5 GPS Smartwatch 42 mm Fiber-reinforced polymer - Slate Aluminum and Black", "SmartWatches", 453.00));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return productList;
        }
    
        return productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) ||
                             p.getCategory().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
    
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
}
