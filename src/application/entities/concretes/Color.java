package application.entities.concretes;

import application.core.entitie.abstracts.Entity;

public class Color implements Entity{
	
	private int id;
	private String name;
	
	public Color() {
		// TODO Auto-generated constructor stub
	}	
	
	public Color(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Color(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
