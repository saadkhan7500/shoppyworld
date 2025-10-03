package shoppyworld.Dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shoppyworld.model.Product;
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
				new String[] { "userEmail" }, 
				new Object[] { userEmail });
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
		return purchases;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Purchase> getAllOrderPurchaseRequest() {
		String hql = "FROM Purchase WHERE purchase_status IN (:statUses)";

		List<String> statUses = List.of("request", "show-vendor", "verified");

		List<Purchase> purchases = (List<Purchase>) hibernateTemplate.findByNamedParam(
			hql,
			"statUses",
			statUses
		);

		return purchases;
	}

	@Transactional
	@Override
	public void updatePurchaseStatusByProductId(int productId) {
		Integer rowsUpdated = hibernateTemplate.execute(session -> {
	        String hql = "UPDATE Purchase SET purchase_status = :status WHERE product_id = :productId";
	        Query query = session.createQuery(hql);
	        query.setParameter("status", "show-vendor");
	        query.setParameter("productId", productId);
	        int updatedCount = query.executeUpdate();
	        return updatedCount;
	    });

	    if (rowsUpdated != null && rowsUpdated > 0) {
	        System.out.println("Update successful. Rows affected: " + rowsUpdated);
	    } else {
	        System.out.println("No rows updated. Check if productId exists.");
	    }
	}

}
