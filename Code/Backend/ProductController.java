import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

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
		return true;
	}

	public boolean removeProduct(Product product) {
		if (products.contains(product)) {
			products.remove(product);
			return true;
		} else {
			System.out.println("Product does not exist.");
		}
		return false;
	}

	public ArrayList<Product> listAllProducts() {
		return products;
	}

	public boolean doesProductExist(Product product) {
		if (products.contains(product)) {
			return true;
		}
		return false;
	}
}