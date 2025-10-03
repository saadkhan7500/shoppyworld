package shoppyworld.Dao;

import shoppyworld.model.Admin;

public interface AdminDao {

	public Admin getUserByEmailAndPassword(String email, String password);

}
