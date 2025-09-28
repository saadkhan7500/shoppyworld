package shoppyworld.Dao;

import java.util.List;

import shoppyworld.model.Cart;

public interface CartDao {
	
	public List<Cart> getCartItemsByUserId(int userId);
}
