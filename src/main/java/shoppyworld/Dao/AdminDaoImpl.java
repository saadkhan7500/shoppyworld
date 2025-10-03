package shoppyworld.Dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import shoppyworld.model.Admin;

@Service
public class AdminDaoImpl implements AdminDao {
	
	private final HibernateTemplate hibernateTemplate;

	public AdminDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Admin getUserByEmailAndPassword(String email, String password) {
	    String hql = "FROM Admin WHERE email = :email AND password = :password";
	    List<Admin> admins = (List<Admin>) hibernateTemplate.findByNamedParam(
	        hql,
	        new String[] {"email", "password"},
	        new Object[] {email, password}
	    );
	    return admins.isEmpty() ? null : admins.get(0);
	}

}
