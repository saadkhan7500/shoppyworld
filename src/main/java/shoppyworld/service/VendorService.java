package shoppyworld.service;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.VendorDao;
import shoppyworld.model.Vendor;

@Service
public class VendorService {
	
	private final VendorDao vendorDao;

	public VendorService(VendorDao vendorDao) {
		super();
		this.vendorDao = vendorDao;
	}
	
	public int createVendor(Vendor vendor)
	{
		return vendorDao.createVendor(vendor);
	}

}
