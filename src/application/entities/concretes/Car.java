package application.entities.concretes;

public class Car {
	private int id;
	private int modelId;
	private int brandId;
	private int colorId;
	private int dailyPrice;
	private int modelYear;
	private String description;
	private int findeksScore;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int id, int modelId, int brandId, int colorId, int dailyPrice, int modelYear, String description,
			int findeksScore) {
		super();
		this.id = id;
		this.modelId = modelId;
		this.brandId = brandId;
		this.colorId = colorId;
		this.dailyPrice = dailyPrice;
		this.modelYear = modelYear;
		this.description = description;
		this.findeksScore = findeksScore;
	}
	
	public Car(int modelId, int brandId, int colorId, int dailyPrice, int modelYear, String description,
			int findeksScore) {
		super();
		this.modelId = modelId;
		this.brandId = brandId;
		this.colorId = colorId;
		this.dailyPrice = dailyPrice;
		this.modelYear = modelYear;
		this.description = description;
		this.findeksScore = findeksScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFindeksScore() {
		return findeksScore;
	}

	public void setFindeksScore(int findeksScore) {
		this.findeksScore = findeksScore;
	}
	
	
}
