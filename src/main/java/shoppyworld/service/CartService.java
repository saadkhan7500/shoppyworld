package shoppyworld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.CartDao;
import shoppyworld.Dao.ProductDao;
import shoppyworld.model.Cart;
import shoppyworld.model.Product;

@Service
public class CartService {
	
	private final CartDao cartDao;
	
	private final ProductDao productDao;

	public CartService(CartDao cartDao, ProductDao productDao) {
		super();
		this.cartDao = cartDao;
		this.productDao = productDao;
	}
	
	
	public List<Product> getProductsInUserCart(int userId) {
	    List<Cart> carts = cartDao.getCartItemsByUserId(userId);

	    List<Product> products = new ArrayList<>();
	    for (Cart cart : carts) {
	        Product product = productDao.getProductById(cart.getProduct_id());
	        if (product != null) {
	            products.add(product);
	        }
	    }

	    return products;
	}
	

}
