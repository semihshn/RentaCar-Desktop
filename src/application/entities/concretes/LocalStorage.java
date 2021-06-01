package application.entities.concretes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocalStorage {
	
	public static String userName;
	public static String email;
	public static Date age;
	public static List<String> authority=new ArrayList<String>();
	public static int userId;
	
	
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		LocalStorage.userName = userName;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		LocalStorage.email = email;
	}
	public static Date getAge() {
		return age;
	}
	public static void setAge(Date age) {
		LocalStorage.age = age;
	}
	public static List<String> getAuthority() {
		return authority;
	}
	public static void setAuthority(String authority) {
		LocalStorage.authority.add(authority);
	}
	public static int getUserId() {
		return userId;
	}
	public static void setUserId(int userId) {
		LocalStorage.userId = userId;
	}

	
}
