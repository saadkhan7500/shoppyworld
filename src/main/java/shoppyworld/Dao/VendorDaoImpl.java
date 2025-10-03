package shoppyworld.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shoppyworld.model.User;
import shoppyworld.model.Vendor;

@Service
public class VendorDaoImpl implements VendorDao {
	
	private final HibernateTemplate hibernateTemplate;

	public VendorDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int createVendor(Vendor vendor)
	{
		return (int)hibernateTemplate.save(vendor);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Vendor getVendorByEmailAndPassword(String email, String password) {
	    String hql = "FROM Vendor WHERE email = :email AND password = :password";
	    List<Vendor> vendors = (List<Vendor>) hibernateTemplate.findByNamedParam(
	        hql,
	        new String[] {"email", "password"},
	        new Object[] {email, password}
	    );
	    return vendors.isEmpty() ? null : vendors.get(0);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return hibernateTemplate.loadAll(Vendor.class);
	}

}
