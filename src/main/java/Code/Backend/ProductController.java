import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;
import Code.Backend.Product;

/**
 * a) Class Name: ProductController
 * b) Date: April 15, 2025
 * c) Programmer: Fahim Ramez
 * d) Description:
 * This class handles the logic for managing a list of Product objects. It
 * supports
 * loading and saving products from/to a text file, adding new products,
 * removing
 * existing ones, and checking if a product exists.
 *
 * e) Important Functions:
 * - loadProducts(): Reads data from "products.txt" and adds to the products
 * list.
 * - saveProducts(): Writes all current products to "products.txt".
 * - addProduct(Product product, String productID): Adds a product, checks if
 * not already present.
 * - removeProduct(String productID): Removes a product by its ID.
 * - listAllProducts(): Displays and returns all products.
 * - doesProductExist(String productID): Checks if a product exists by ID.
 *
 * f) Data Structures:
 * - ArrayList Product: Used to store and manage the list of products.
 *
 * g) Algorithms:
 * - Linear search is used in addProduct(), removeProduct(), and
 * doesProductExist() to find products by ID.
 */

public class ProductController {

	private ArrayList<Product> products;

	public ProductController() {
		this.products = new ArrayList<>();
	}

	// method to load all the products in the txt file into the products list
	public void loadProducts() {
		// create the file that i will load products from
		File file = new File("products.txt");

		// clear the list so there are no duplicates
		products.clear();

		if (file.exists()) {
			try {
				// create scanner
				Scanner scnr = new Scanner(file);
				// assign to line and loop trhough all lines
				while (scnr.hasNextLine()) {
					String line = scnr.nextLine();

					// split each line into 4 parts for each attribute
					String[] splittedLine = line.split(", ");

					// save the splits in the line in 4 []
					if (splittedLine.length == 4) {
						String productID = splittedLine[0];
						String productName = splittedLine[1];
						double price = Double.parseDouble(splittedLine[2]);
						int quantity = Integer.parseInt(splittedLine[3]);

						// add products
						products.add(new Product(productID, productName, price, quantity));
					}
				}
				scnr.close();
			} catch (Exception e) {
				System.out.println("Error: could not load the products." + e.getMessage());
			}
		} else {
			System.out.println("File products.txt does not exist.");
		}
	}

	// method to save products and write them back into the txt file
	public void saveProducts() {
		try {
			// create a writer
			PrintWriter writer = new PrintWriter("products.txt");

			// loop through products and print them
			for (Product product : products) {
				String line = product.getProductID() + ", " + product.getProductName() + ", " +
						product.getPrice() + ", " + product.getQuantity();
				writer.println(line);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: Could not save the products into products.txt." + e.getMessage());
		}
	}

	// add products to the list
	public void addProduct(Product product, String productID) {
		for (Product p : products) {
			if (p.getProductID().equals(productID)) {
				System.out.printf("Product %s already exists.\n", productID);
				return;
			}
		}
		products.add(product);
	}

	public boolean removeProduct(String productID) {
		// go through the list and loop
		for (Product product : products) {

			// if productID is found, remove
			if (product.getProductID().equals(productID)) {
				products.remove(product);
				System.out.println("Product with productID " + productID + " has been removed.");
				return true;
			}
		}
		// if not, it doesnt exist
		System.out.println("Product does not exist.");
		return false;
	}

	public ArrayList<Product> listAllProducts() {
		for (Product product : products) {
			System.out.println(product.getProductID() + ", " + product.getProductName() + ", " +
					product.getPrice() + ", " + product.getQuantity());
		}
		return products;
	}

	public boolean doesProductExist(String productID) {
		for (Product product : products) {
			if (product.getProductID().equals(productID)) {
				System.out.println("Product exists.");
				return true;
			}
		}
		System.out.println("Product does not exist.");
		return false;
	}
}