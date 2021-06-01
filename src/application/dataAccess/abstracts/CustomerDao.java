package application.dataAccess.abstracts;

import java.util.List;

import application.entities.concretes.Customer;

public interface CustomerDao {
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	
	List<Customer> getAll();
	Customer get(int id);
	Customer getByUserId(int userId);
}
