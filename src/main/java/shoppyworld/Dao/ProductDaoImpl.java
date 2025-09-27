package shoppyworld.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import shoppyworld.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{


	private final HibernateTemplate hibernateTemplate;
	
	public ProductDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		return hibernateTemplate.loadAll(Product.class);
	}

}
