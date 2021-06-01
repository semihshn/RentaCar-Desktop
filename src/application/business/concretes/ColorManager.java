package application.business.concretes;

import java.util.List;

import application.business.abstracts.ColorService;
import application.dataAccess.abstracts.ColorDao;
import application.entities.concretes.Color;

public class ColorManager implements ColorService{
	
	private ColorDao colorDao;
	
	public ColorManager(ColorDao colorDao) {
		// TODO Auto-generated constructor stub
		this.colorDao = colorDao;
	}

	@Override
	public void add(Color color) {
		// TODO Auto-generated method stub
		colorDao.add(color);
	}

	@Override
	public void update(Color color) {
		// TODO Auto-generated method stub
		colorDao.update(color);
	}

	@Override
	public void delete(Color color) {
		// TODO Auto-generated method stub
		colorDao.delete(color);
	}

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colorDao.getAll();
	}

	@Override
	public Color get(int id) {
		// TODO Auto-generated method stub
		return colorDao.get(id);
	}

}
