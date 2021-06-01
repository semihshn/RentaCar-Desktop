package application.business.concretes;

import java.util.Date;

import application.business.abstracts.AuthService;
import application.core.entitie.concretes.User;
import application.core.utilities.security.encryption.EncryptHelper;
import application.dataAccess.abstracts.UserDao;

public class AuthManager implements AuthService{
	
	private UserDao userDao;
	
	public AuthManager(UserDao userDao) {
		// TODO Auto-generated constructor stub
		this.userDao = userDao;
	}

	@Override
	public Boolean Register(String firstName, String lastName, String email, String passwordHash, boolean status,
			Date age) {
		// TODO Auto-generated method stub
    	
		try {
	    	String Encrypted=EncryptHelper.encryptMD5(passwordHash);
	    	
	    	userDao.add(
	    			new User(
	    					firstName,
	    					lastName,
	    					email,
	    					Encrypted,
	    					age
	    					));
	    	
	    	return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public User Login(String email, String passwordHash) {
		// TODO Auto-generated method stub
		String encrypPassword=EncryptHelper.encryptMD5(passwordHash);

		return userDao.login(email, encrypPassword);
	}
	

}
