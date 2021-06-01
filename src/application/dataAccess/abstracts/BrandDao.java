package application.dataAccess.abstracts;

import java.util.List;

import application.entities.concretes.Brand;

public interface BrandDao {
	void add(Brand brand);
	void update(Brand brand);
	void delete(Brand brand);
	
	List<Brand> getAll();
	Brand get(int id);
}
