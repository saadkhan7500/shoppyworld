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

}
