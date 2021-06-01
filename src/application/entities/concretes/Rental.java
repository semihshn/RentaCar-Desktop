package application.entities.concretes;

import java.sql.Date;

import application.core.entitie.abstracts.Entity;

public class Rental implements Entity{

	private int id;
	private int carId;
	private int customerId;
	private Date rentDate;
	private Date returnDate;
	
	public Rental() {
		// TODO Auto-generated constructor stub
	}

	public Rental(int id, int carId, int customerId, Date rentDate, Date returnDate) {
		super();
		this.id = id;
		this.carId = carId;
		this.customerId = customerId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}
	
	public Rental(int carId, int customerId, Date rentDate, Date returnDate) {
		super();
		this.carId = carId;
		this.customerId = customerId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
}
