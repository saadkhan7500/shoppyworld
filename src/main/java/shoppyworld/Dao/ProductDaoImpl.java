package shoppyworld.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shoppyworld.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private final HibernateTemplate hibernateTemplate;

	public ProductDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		return hibernateTemplate.loadAll(Product.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Product getProductById(int productId) {
		String hql = "FROM Product WHERE id = :id";
		List<Product> products = (List<Product>) hibernateTemplate.findByNamedParam(hql, new String[] { "id" },
				new Object[] { productId });
		return products.isEmpty() ? null : products.get(0);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> getProductByEmail(String email) {
		String hql = "FROM Product where product_owner_email = :email";
		List<Product> products = (List<Product>) hibernateTemplate.findByNamedParam(hql, new String[] { "email" },
				new Object[] { email });
		return products;
	}

	@Transactional
	@Override
	public int createProduct(Product product) {
		return (int) hibernateTemplate.save(product);
	}

	@Transactional
	@Override
	public void uploadProductImage(int productId, String originalFilename) {
		Product product = hibernateTemplate.get(Product.class, productId);
		if (product != null) {
			product.setP_i_name(originalFilename);
			hibernateTemplate.update(product);
		} else {
			// Log or throw an exception if product not found
			throw new RuntimeException("Product with ID " + productId + " not found.");
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> getProductByCategory(String product_category) {
		String hql = "FROM Product WHERE product_category = :product_category";
		List<Product> products = (List<Product>) hibernateTemplate.findByNamedParam(hql, new String[] { "product_category" },
				new Object[] { product_category });
		return products;
	}

}
