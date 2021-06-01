package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.dataAccess.abstracts.BrandDao;
import application.entities.concretes.Brand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateBrandDao implements BrandDao{
	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateBrandDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Brand brand) {
		// TODO Auto-generated method stub
		sql="insert into brands (Name) values (?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, brand.getName());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(Brand brand) {
		// TODO Auto-generated method stub
		sql="update brands set Name=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, brand.getName());
			query.setInt(2, brand.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Brand brand) {
		// TODO Auto-generated method stub
    	sql="delete from brands where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, brand.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Brand get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from brands where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Brand brand=new Brand(result.getInt("Id"),result.getString("Name"));
			
			return brand;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Brand> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from brands";
		
		ObservableList<Brand> brands=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				brands.add(new Brand(result.getInt("Id"),result.getString("Name")));
				
			}
			
			return brands;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}
}
