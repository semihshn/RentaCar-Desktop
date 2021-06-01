package application.business.abstracts;

import java.util.List;

import application.entities.concretes.Color;

public interface ColorService {
	void add(Color color);
	void update(Color color);
	void delete(Color color);
	
	List<Color> getAll();
	Color get(int id);
}
