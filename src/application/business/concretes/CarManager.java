package application.business.concretes;

import java.util.List;

import application.business.abstracts.CarService;
import application.dataAccess.abstracts.CarDao;
import application.entities.DTOs.CarDetailDto;
import application.entities.concretes.Car;

public class CarManager implements CarService{

private CarDao carDao;
	
	public CarManager(CarDao carDao) {
		// TODO Auto-generated constructor stub
		this.carDao = carDao;
	}

	@Override
	public void add(Car car) {
		// TODO Auto-generated method stub
		carDao.add(car);
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		carDao.update(car);
	}

	@Override
	public void delete(Car car) {
		// TODO Auto-generated method stub
		carDao.delete(car);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return carDao.getAll();
	}

	@Override
	public Car get(int id) {
		// TODO Auto-generated method stub
		return carDao.get(id);
	}

	@Override
	public List<CarDetailDto> getCarDetails() {
		// TODO Auto-generated method stub
		return carDao.getCarDetails();
	}

	@Override
	public List<CarDetailDto> getCarDetailsByName(String carName) {
		// TODO Auto-generated method stub
		return carDao.getCarDetailsByName(carName);
	}

	@Override
	public CarDetailDto getCarDetailsByCarId(int carId) {
		// TODO Auto-generated method stub
		return carDao.getCarDetailsByCarId(carId);
	}
}
