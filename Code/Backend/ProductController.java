import java.util.ArrayList;
import java.util.List;

public class ProductController {

	private ArrayList<Product> products;

	public ProductController() {
		this.products = new ArrayList<>();
	}

	public boolean addProduct(Product product) {
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