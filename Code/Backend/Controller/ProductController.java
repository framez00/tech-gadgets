import java.util.ArrayList;

public class ProductController{

	private ArrayList<Product> productList;

	public void addProduct(Product product){
		productList.add(product);
	}

	public void removeProduct(Product product){
		productList.remove(product);
	}

	public ArrayList<Product>listAllProducts(){
		return productList;
	}
}