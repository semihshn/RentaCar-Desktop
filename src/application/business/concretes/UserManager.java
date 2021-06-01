package application.business.concretes;

import java.util.List;

import application.business.abstracts.UserService;
import application.core.entitie.concretes.OperationClaim;
import application.core.entitie.concretes.User;
import application.dataAccess.abstracts.UserDao;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		// TODO Auto-generated constructor stub
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public List<OperationClaim> GetClaims(User user) {
		// TODO Auto-generated method stub
		return userDao.GetClaims(user);
	}

}
