package shoppyworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.AdminDao;
import shoppyworld.Dao.ProductDao;
import shoppyworld.Dao.PurchaseDao;
import shoppyworld.Dao.UserDao;
import shoppyworld.Dao.VendorDao;
import shoppyworld.model.Admin;
import shoppyworld.model.Product;
import shoppyworld.model.Purchase;
import shoppyworld.model.User;
import shoppyworld.model.Vendor;

@Service
public class AdminService {

	private final AdminDao adminDao;

	private final VendorDao vendorDao;

	private final UserDao userDao;

	private final PurchaseDao purchaseDao;

	private final ProductDao productDao;

	public AdminService(AdminDao adminDao, VendorDao vendorDao, UserDao userDao
			,PurchaseDao purchaseDao
			,ProductDao productDao) {
		super();
		this.adminDao = adminDao;
		this.vendorDao = vendorDao;
		this.userDao = userDao;
		this.purchaseDao = purchaseDao;
		this.productDao = productDao;
	}

	public Admin findByEmailAndPassword(String email, String password) {

		Admin user = adminDao.getUserByEmailAndPassword(email, password);
		if (user == null) {
			return null;
		}
		return user;

	}

	public List<Vendor> getAllVendors() {
		return vendorDao.getAllVendors();
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<Purchase> getAllOrderPurchaseRequest() {
		return purchaseDao.getAllOrderPurchaseRequest();
	}

	public void updatePurchaseStatusByProductId(int productId) {
		purchaseDao.updatePurchaseStatusByProductId(productId);

	}

	public List<Product> getAllNewlyAddedProduct() {
		
		return productDao.getAllNewlyAddedProduct();

	}

}
