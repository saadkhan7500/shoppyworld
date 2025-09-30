package shoppyworld.Dao;

import java.util.List;

import shoppyworld.model.Product;

public interface ProductDao {

	public List<Product> getAllProducts();
	
	public Product getProductById(int productIds);
	
	public List<Product> getProductByEmail(String email);

	public int createProduct(Product product);

	public void uploadProductImage(int productId, String originalFilename);

	public List<Product> getProductByCategory(String product_category);


}
