package application.business.concretes;

import java.util.List;

import application.business.abstracts.ModelService;
import application.dataAccess.abstracts.ModelDao;
import application.entities.concretes.Model;

public class ModelManager implements ModelService{
	
	private ModelDao modelDao;
	
	public ModelManager(ModelDao modelDao) {
		// TODO Auto-generated constructor stub
		this.modelDao = modelDao;
	}

	@Override
	public void add(Model model) {
		// TODO Auto-generated method stub
		modelDao.add(model);
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		modelDao.update(model);
	}

	@Override
	public void delete(Model model) {
		// TODO Auto-generated method stub
		modelDao.delete(model);
	}

	@Override
	public List<Model> getAll() {
		// TODO Auto-generated method stub
		return modelDao.getAll();
	}

	@Override
	public Model get(int id) {
		// TODO Auto-generated method stub
		return modelDao.get(id);
	}
}
