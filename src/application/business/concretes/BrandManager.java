package application.business.concretes;

import java.util.List;

import application.business.abstracts.BrandService;
import application.dataAccess.abstracts.BrandDao;
import application.entities.concretes.Brand;

public class BrandManager implements BrandService{
	
	private BrandDao brandDao;
	
	public BrandManager(BrandDao brandDao) {
		// TODO Auto-generated constructor stub
		this.brandDao = brandDao;
	}

	@Override
	public void add(Brand brand) {
		// TODO Auto-generated method stub
		brandDao.add(brand);
	}

	@Override
	public void update(Brand brand) {
		// TODO Auto-generated method stub
		brandDao.update(brand);
	}

	@Override
	public void delete(Brand brand) {
		// TODO Auto-generated method stub
		brandDao.delete(brand);
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandDao.getAll();
	}

	@Override
	public Brand get(int id) {
		// TODO Auto-generated method stub
		return brandDao.get(id);
	}
}
