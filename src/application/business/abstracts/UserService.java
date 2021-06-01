package application.business.abstracts;

import java.util.List;

import application.core.entitie.concretes.OperationClaim;
import application.core.entitie.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
	
	List<User> getAll();
	User get(int id);
	List<OperationClaim> GetClaims(User user);
}
