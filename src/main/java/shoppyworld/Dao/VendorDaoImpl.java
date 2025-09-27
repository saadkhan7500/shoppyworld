package shoppyworld.Dao;

import java.io.Serializable;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
