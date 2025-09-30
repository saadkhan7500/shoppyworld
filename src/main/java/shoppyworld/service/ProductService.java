package shoppyworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.ProductDao;
import shoppyworld.model.Product;

@Service
public class ProductService {
	
	private final ProductDao productDao;

	public ProductService(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	
	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}


	public int createProduct(Product product) {
		return productDao.createProduct(product);
	}


	public Product getProductById(int id) {	
		
		return productDao.getProductById(id);
		
	}


	public List<Product> getProductByCategory(String product_category) {
		
		return productDao.getProductByCategory(product_category);
	}

}
