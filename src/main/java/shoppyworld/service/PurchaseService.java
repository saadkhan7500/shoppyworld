package shoppyworld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.ProductDao;
import shoppyworld.Dao.PurchaseDao;
import shoppyworld.model.Product;
import shoppyworld.model.Purchase;

@Service
public class PurchaseService {
	
	private final PurchaseDao purchaseDao;
	
	private final ProductDao productDao;

	public PurchaseService(PurchaseDao purchaseDao, ProductDao productDao) {
		super();
		this.purchaseDao = purchaseDao;
		this.productDao = productDao;
	}
	
	
	public List<Product> getProductsInUserCart(String userEmail) {
	    List<Purchase> purchases = purchaseDao.getPurchaseItemsByUserId(userEmail);

	    List<Product> products = new ArrayList<>();
	    for (Purchase purchase : purchases) {
	        Product product = productDao.getProductById(purchase.getProduct_id());
	        if (product != null) {
	            products.add(product);
	        }
	    }
	    
	    return products;
	}
	

}
