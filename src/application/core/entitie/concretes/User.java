package application.core.entitie.concretes;



import java.util.Date;

import application.core.entitie.abstracts.Entity;

public class User implements Entity{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String passwordHash;
	private boolean status;
	private Date age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, String email, String passwordHash, boolean status,
			Date age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.status = status;
		this.age = age;
	}
	
	public User(String firstName, String lastName, String email, String passwordHash,Date age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}
	
	
	
}
