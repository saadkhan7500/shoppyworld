package shoppyworld.Dao;

import shoppyworld.model.Vendor;

public interface VendorDao {
	
	public int createVendor(Vendor vendor);

	public Vendor getVendorByEmailAndPassword(String email, String password);

}
