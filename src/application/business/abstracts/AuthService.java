package application.business.abstracts;

import java.util.Date;

import application.core.entitie.concretes.User;

public interface AuthService {
	
	Boolean Register(String firstName,String lastName,String email,String passwordHash,boolean status,Date age);
	User Login(String email,String passwordHash);

}
