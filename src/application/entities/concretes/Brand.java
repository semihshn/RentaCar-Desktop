package application.entities.concretes;

public class Brand {
	private int id;
	private String name;
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int id, String name) {
		super();
		this.id=id;
		this.name = name;
	}
	
	public Brand(String name) {
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
