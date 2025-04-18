package com.infinitytech.ecommerce.controller;

<<<<<<< HEAD

=======
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
import com.infinitytech.ecommerce.model.Product;
import com.infinitytech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD

import java.util.List;


=======
import java.util.List;

>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

<<<<<<< HEAD
   @Autowired
   private ProductService productService;


   @GetMapping("/search")
   public List<Product> search(@RequestParam(required = false) String name) {
       return productService.searchProducts(name);
   }


   @GetMapping
   public List<Product> getAll() {
       return productService.getAllProducts();
   }
=======
    // Search products by name (optional query param)
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) String name) {
        return productService.searchProducts(name);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
}
