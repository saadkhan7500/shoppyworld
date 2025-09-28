package shoppyworld.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shoppyworld.model.User;

@Service
public class UserDaoImpl implements UserDao {
	
	private final HibernateTemplate hibernateTemplate;

	public UserDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int createUser(User user)
	{
		return (int)hibernateTemplate.save(user);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public User getUserByEmailAndPassword(String email, String password) {
	    String hql = "FROM User WHERE email = :email AND password = :password";
	    List<User> users = (List<User>) hibernateTemplate.findByNamedParam(
	        hql,
	        new String[] {"email", "password"},
	        new Object[] {email, password}
	    );
	    return users.isEmpty() ? null : users.get(0);
	}

}
