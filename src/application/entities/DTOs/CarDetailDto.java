package application.entities.DTOs;

import application.core.entitie.abstracts.Dto;

public class CarDetailDto implements Dto{
	
	private int carId;
	private String carname;
	private String brandName;
	private String colorName;
	private String modelName;
	private int dailyPrice;
	private int modelYear;
	private String description;
	
	public CarDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public CarDetailDto(int carId, String carname, String modelName, String brandName, String colorName, int dailyPrice, int modelYear,
			String description) {
		super();
		this.carId = carId;
		this.carname = carname;
		this.modelName=modelName;
		this.brandName = brandName;
		this.colorName = colorName;
		this.dailyPrice = dailyPrice;
		this.modelYear = modelYear;
		this.description = description;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
}
