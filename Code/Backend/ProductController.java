import java.io.*;
import java.util.*;
//imported ArrayLists, BufferedReader, FileReader

public class ProductController{

	//create a list that can hold all products
	private ArrayList<Product> products;

	//initialize the list
	public ProductController(){
		this.products = new ArrayList<>();
		loadProducts();
	}

	//method to load all the products in the txt file
	public void loadProducts(){
		//create the file that i will load products from
		File file = new File("products.txt");

		//clear the list so there are no duplicates
		products.clear();


		if(file.exists()){
			try{
				//create scanner
				Scanner scnr = new Scanner(file);
				//assign to line and loop trhough all lines
				while(scnr.hasNextLine()){
					String line = scnr.nextLine();

					//split each line into 4 parts for each attribute
					String[]splittedLine = line.split(", ");

					//save the splits in the line in 4 []
					if(splittedLine.length == 4){
						String productID = splittedLine[0];
						String productName = splittedLine[1];
						double price = Double.parseDouble(splittedLine[2]);
						int quantity = Integer.parseInt(splittedLine[3]);
						
						//add products
						products.add(new Product(productID, productName, price, quantity));
					}
				}
				scnr.close();
			}catch(Exception e){
				System.out.println("Error: could not load the products." + e.getMessage());
			}
		}else{
			System.out.println("File products.txt does not exist.");
		}
	}

	//method to save the products in txt file
	public void saveProducts(){
		try{
			//create a writer
			PrintWriter writer = new PrintWriter("products.txt");
	
			//loop through products and print them
			for(Product product : products){
				String line = product.getProductID() + ", " + product.getProductName() + ", " +
							 product.getPrice() + ", " + product.getQuantity();
				writer.println(line);
			}
			writer.close();
		}catch (Exception e){
			System.out.println("Error: Could not save the products into products.txt." + e.getMessage());
		}
	}

	//add products to the list
	public void addProduct(Product product){
		products.add(product);
	}

	//remove products
	public boolean removeProduct(String productID){
		//go through the list and loop
		for(Product product : products){

			//if productID is found, remove
			if(product.getProductID().equals(productID)){
				products.remove(product);
				System.out.println("Product with product id " + productID + " has been removed.");
				return true;
			}
			//if not, it does not exist
			else{
			System.out.println("Product does not exist.");
			}
		}
		return false;
	}

	//list all products in the list
	public ArrayList<Product>listAllProducts(){
		for(Product product : products){
			System.out.println(product.getProductID() + ", " + product.getProductName() + "," +
							   product.getPrice() + "," + product.getQuantity());
		}
		return products;
	}

	//check if product exists
	public boolean doesProductExist(String productID){
		//loop through products, if id exists then product exists
		for(Product product : products){
			if(product.getProductID().equals(productID)){
				return true;
			}
		}
		return false;
	}
}