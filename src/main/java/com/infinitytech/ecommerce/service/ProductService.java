package com.infinitytech.ecommerce.service;


import com.infinitytech.ecommerce.model.Product;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
}
