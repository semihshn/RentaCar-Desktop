package application.business.concretes;

import java.util.List;

import application.business.abstracts.CustomerService;
import application.dataAccess.abstracts.CustomerDao;
import application.entities.concretes.Customer;
public class CustomerManager implements CustomerService{

private CustomerDao customerDao;
	
	public CustomerManager(CustomerDao customerDao) {
		// TODO Auto-generated constructor stub
		this.customerDao = customerDao;
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.add(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDao.getAll();
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return customerDao.get(id);
	}

	@Override
	public Customer getByUserId(int userId) {
		// TODO Auto-generated method stub
		return customerDao.getByUserId(userId);
	}
	
}
