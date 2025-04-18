package com.infinitytech.ecommerce.controller;


import com.infinitytech.ecommerce.model.Product;
import com.infinitytech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {


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
}
