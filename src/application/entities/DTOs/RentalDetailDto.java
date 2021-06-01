package application.entities.DTOs;

import java.sql.Date;

public class RentalDetailDto {
	
	private int rentalId;
	private int carId;
	private String carName;
	private String userName;
	private String customerName;
	private Date rentDate;
	private Date returnDate;
	private int totalPrice;
	
	public RentalDetailDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RentalDetailDto(int rentalId, int carId, String carName, String userName, String customerName, Date rentDate,
			Date returnDate,int totalPrice) {
		super();
		this.rentalId = rentalId;
		this.carId = carId;
		this.carName = carName;
		this.userName = userName;
		this.customerName = customerName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
