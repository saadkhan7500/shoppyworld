package shoppyworld.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import shoppyworld.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private final HibernateTemplate hibernateTemplate;

	public CartDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Cart> getCartItemsByUserId(int userId) {
		String hql = "FROM Cart WHERE user_id = :userId AND product_id IS NOT NULL";
		List<Cart> carts = (List<Cart>) hibernateTemplate.findByNamedParam(hql, new String[] { "userId" },
				new Object[] { userId });

		return carts;
	}

}
