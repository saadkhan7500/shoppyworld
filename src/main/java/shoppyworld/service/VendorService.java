package shoppyworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.ProductDao;
import shoppyworld.Dao.VendorDao;
import shoppyworld.model.Product;
import shoppyworld.model.Vendor;

@Service
public class VendorService {

	private final VendorDao vendorDao;
	
	private final ProductDao productDao;

	public VendorService(VendorDao vendorDao, ProductDao productDao) {
		super();
		this.vendorDao = vendorDao;
		this.productDao = productDao;
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
	
	public List<Product> getProductByEmail(String email)
	{
		return productDao.getProductByEmail(email);
	}

}
