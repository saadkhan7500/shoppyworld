package shoppyworld.Dao;

import java.util.List;

import shoppyworld.model.Product;
import shoppyworld.model.Purchase;

public interface PurchaseDao {

	public List<Purchase> getPurchaseItemsByUserId(String userId);
	
	public List<Purchase> getPurchaseByEmailAndPurchase(String email);

	public List<Purchase> getAllOrderPurchaseRequest();

	public void updatePurchaseStatusByProductId(int productId);
	
}
