package application.entities.concretes;

import application.core.entitie.abstracts.Entity;

public class Customer implements Entity {
	
	private int id;
	private int userId;
	private String companyName;
	private int findeksScore;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int id, int userId, String companyName, int findeksScore) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyName = companyName;
		this.findeksScore = findeksScore;
	}
	
	public Customer(int userId, String companyName, int findeksScore) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.findeksScore = findeksScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getFindeksScore() {
		return findeksScore;
	}

	public void setFindeksScore(int findeksScore) {
		this.findeksScore = findeksScore;
	}
}
