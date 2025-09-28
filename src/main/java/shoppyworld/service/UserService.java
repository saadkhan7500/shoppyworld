package shoppyworld.service;

import org.springframework.stereotype.Service;

import shoppyworld.Dao.UserDao;
import shoppyworld.model.User;

@Service
public class UserService {
	
	private final UserDao userDao;

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public int createUser(User user)
	{
		return userDao.createUser(user);
	}

	public User findByEmailAndPassword(String email, String password) {
		
		User user = userDao.getUserByEmailAndPassword(email, password);
		if(user == null) {
			return null;
		}
		return user;
		
	}

}
