package application.helper;

public class ConfigurationCombo {
	
	int id;
	String content;
	
	@Override
	public String toString() {
	    return this.getContent();
	}
	
	public ConfigurationCombo(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
