package application.business.abstracts;

import java.util.List;

import application.entities.DTOs.CarDetailDto;
import application.entities.concretes.Car;

public interface CarService {
	void add(Car car);
	void update(Car car);
	void delete(Car car);
	
	List<Car> getAll();
	Car get(int id);
	
	List<CarDetailDto> getCarDetails();
	CarDetailDto getCarDetailsByCarId(int carId);
	List<CarDetailDto> getCarDetailsByName(String carName);
}
