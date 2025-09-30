package shoppyworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.ProductDao;
import shoppyworld.Dao.PurchaseDao;
import shoppyworld.Dao.VendorDao;
import shoppyworld.model.Product;
import shoppyworld.model.Purchase;
import shoppyworld.model.Vendor;

@Service
public class VendorService {

	private final VendorDao vendorDao;
	
	private final ProductDao productDao;
	
	private final PurchaseDao purchaseDao;

	public VendorService(VendorDao vendorDao, ProductDao productDao, PurchaseDao purchaseDao) {
		super();
		this.vendorDao = vendorDao;
		this.productDao = productDao;
		this.purchaseDao = purchaseDao;
	}

	public int createVendor(Vendor vendor) {
		return vendorDao.createVendor(vendor);
	}

	public Vendor findByEmailAndPassword(String email, String password) {
		
		Vendor vendor = vendorDao.getVendorByEmailAndPassword(email, password);
		
		if (vendor == null) {
			return null;
		}
		return vendor;

	}
	
	public List<Product> getProductByEmail(String email){
		
		return productDao.getProductByEmail(email);
	}

	public void uploadProductImage(int productId, String originalFilename) {
		
		productDao.uploadProductImage(productId, originalFilename);
		
	}

	public List<Purchase> getPurchaseByEmailAndStatus(String email) {
		
		return purchaseDao.getPurchaseByEmailAndPurchase(email);
	}

}
