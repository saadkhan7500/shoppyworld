package shoppyworld.Dao;

import shoppyworld.model.User;

public interface UserDao {
	
	public int createUser(User user);

	public User getUserByEmailAndPassword(String email, String password);

}
