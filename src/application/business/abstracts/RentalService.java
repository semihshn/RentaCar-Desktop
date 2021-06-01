package application.business.abstracts;

import java.util.List;

import application.entities.DTOs.RentalDetailDto;
import application.entities.concretes.Rental;

public interface RentalService {

	void add(Rental rental);
	void update(Rental rental);
	void delete(Rental rental);
	
	List<Rental> getAll();
	List<RentalDetailDto> getRentalDetails();
	Rental get(int id);
}
