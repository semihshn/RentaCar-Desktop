package application.core.entitie.concretes;

import application.core.entitie.abstracts.Entity;

public class OperationClaim implements Entity {

	private int id;
	private String Name;
	
	public OperationClaim() {
		// TODO Auto-generated constructor stub
	}

	public OperationClaim(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
