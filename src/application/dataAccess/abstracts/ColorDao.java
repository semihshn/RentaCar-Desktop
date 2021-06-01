package application.dataAccess.abstracts;

import java.util.List;

import application.entities.concretes.Color;

public interface ColorDao {
	
	void add(Color color);
	void update(Color color);
	void delete(Color color);
	
	List<Color> getAll();
	Color get(int id);
}
