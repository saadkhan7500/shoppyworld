package shoppyworld.Dao;

import java.io.Serializable;

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

}
