import java.util.ArrayList;

public class ProductController{

	private ArrayList<Product> productList;

	public void addProduct(Product product){
		productList.add(product);
	}

	public void removeProduct(Product product){
		if(productList.contains(product)){
			productList.remove(product);
		}else{
			System.out.println("Product does not exist.");
		}
	}

	public ArrayList<Product>listAllProducts(){
		return productList;
	}
}