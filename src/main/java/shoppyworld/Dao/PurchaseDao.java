package shoppyworld.Dao;

import java.util.List;

import shoppyworld.model.Purchase;

public interface PurchaseDao {

	public List<Purchase> getPurchaseItemsByUserId(String userId);
	
}
