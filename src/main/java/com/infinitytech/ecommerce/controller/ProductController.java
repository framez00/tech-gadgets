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
}







