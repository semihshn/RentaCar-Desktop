package application.business.concretes;

import java.util.List;

import application.business.abstracts.RentalService;
import application.dataAccess.abstracts.RentalDao;
import application.entities.DTOs.RentalDetailDto;
import application.entities.concretes.Rental;

public class RentalManager implements RentalService{

private RentalDao rentalDao;
	
	public RentalManager(RentalDao rentalDao) {
		// TODO Auto-generated constructor stub
		this.rentalDao = rentalDao;
	}

	@Override
	public void add(Rental rental) {
		// TODO Auto-generated method stub
		rentalDao.add(rental);
	}

	@Override
	public void update(Rental rental) {
		// TODO Auto-generated method stub
		rentalDao.update(rental);
	}

	@Override
	public void delete(Rental rental) {
		// TODO Auto-generated method stub
		rentalDao.delete(rental);
	}

	@Override
	public List<Rental> getAll() {
		// TODO Auto-generated method stub
		return rentalDao.getAll();
	}

	@Override
	public Rental get(int id) {
		// TODO Auto-generated method stub
		return rentalDao.get(id);
	}

	@Override
	public List<RentalDetailDto> getRentalDetails() {
		// TODO Auto-generated method stub
		return rentalDao.getRentalDetails();
	}
}
