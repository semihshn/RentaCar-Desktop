package application.business.abstracts;

import java.util.List;

import application.entities.concretes.Model;

public interface ModelService {
	void add(Model model);
	void update(Model model);
	void delete(Model model);
	
	List<Model> getAll();
	Model get(int id);
}
