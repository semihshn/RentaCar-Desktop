package application.entities.concretes;

import application.core.entitie.abstracts.Entity;

public class Model implements Entity{
	
	private int id;
	private int brandId;
	private String name;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(int id, int brandId, String name) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
	}
	
	public Model(int brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
