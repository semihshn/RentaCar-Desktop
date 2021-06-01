package application.dataAccess.abstracts;

import java.util.List;

import application.entities.concretes.Model;

public interface ModelDao {

	void add(Model model);
	void update(Model model);
	void delete(Model model);
	
	List<Model> getAll();
	Model get(int id);
}
