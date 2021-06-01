package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.dataAccess.abstracts.CustomerDao;
import application.entities.concretes.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateCustomerDao implements CustomerDao {

	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateCustomerDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		sql="insert into customers (UserId,CompanyName,FindeksScore) values (?,?,?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, customer.getUserId());
			query.setString(2, customer.getCompanyName());
			query.setInt(3, customer.getFindeksScore());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		sql="update customers set UserId=?,CompanyName=?,FindeksScore=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, customer.getUserId());
			query.setString(2, customer.getCompanyName());
			query.setInt(3, customer.getFindeksScore());
			query.setInt(4, customer.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
    	sql="delete from customers where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, customer.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from customers where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Customer customer=new Customer(result.getInt("Id"),result.getInt("UserId"),result.getString("CompanyName"),result.getInt("FindeksScore"));
			
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Customer> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from customers";
		
		ObservableList<Customer> customer=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				customer.add(new Customer(result.getInt("Id"),result.getInt("UserId"),result.getString("CompanyName"),result.getInt("FindeksScore")));
				
			}
			
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public Customer getByUserId(int userId) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from customers where UserId=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, userId);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Customer customer=new Customer(result.getInt("Id"),result.getInt("UserId"),result.getString("CompanyName"),result.getInt("FindeksScore"));
			
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

}
