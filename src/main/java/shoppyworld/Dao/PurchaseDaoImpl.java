package shoppyworld.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import shoppyworld.model.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	private final HibernateTemplate hibernateTemplate;

	public PurchaseDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Purchase> getPurchaseItemsByUserId(String userEmail) {
		String hql = "FROM Purchase WHERE user_email = :userEmail AND product_id IS NOT NULL";
		List<Purchase> purchases = (List<Purchase>) hibernateTemplate.findByNamedParam(hql,
				new String[] { "userEmail" }, new Object[] { userEmail });
		return purchases;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Purchase> getPurchaseByEmailAndPurchase(String email) {
		String hql = "FROM Purchase " + "WHERE LOWER(p_o_email) = :email "
				+ "AND LOWER(purchase_status) IN (:status1, :status2)";

		String cleanedEmail = email.trim().toLowerCase();

		List<Purchase> purchases = (List<Purchase>) hibernateTemplate.findByNamedParam(hql,
				new String[] { "email", "status1", "status2" },
				new Object[] { cleanedEmail, "verified", "show-vendor" });
		
		System.out.println(purchases);
		return purchases;

	}

}
