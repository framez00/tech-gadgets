package com.infinitytech.ecommerce.model;

<<<<<<< HEAD

public class Product {
   private String id;
   private String name;
   private String category;
   private String description;
   private double price;
=======
public class Product {
    private String name;
    private String category;
    private double price;
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6

    // ✅ Default constructor (required for serialization)
    public Product() {
    }

<<<<<<< HEAD
   public Product() {}
=======
    // ✅ Constructor with fields
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6

    // ✅ Getters and setters
    public String getName() {
        return name;
    }

<<<<<<< HEAD
   public Product(String id, String name, String category, String description, double price) {
       this.id = id;
       this.name = name;
       this.category = category;
       this.description = description;
       this.price = price;
   }
=======
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6

    public void setCategory(String category) {
        this.category = category;
    }

<<<<<<< HEAD
   public String getId() { return id; }
   public void setId(String id) { this.id = id; }


   public String getName() { return name; }
   public void setName(String name) { this.name = name; }


   public String getCategory() { return category; }
   public void setCategory(String category) { this.category = category; }


   public String getDescription() { return description; }
   public void setDescription(String description) { this.description = description; }


   public double getPrice() { return price; }
   public void setPrice(double price) { this.price = price; }
=======
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
>>>>>>> 0b8a425c5e94caee370eed7d7e33b95a2e95d1f6
}


