package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.dataAccess.abstracts.ModelDao;
import application.entities.concretes.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateModelDao implements ModelDao{

	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateModelDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Model model) {
		// TODO Auto-generated method stub
		sql="insert into models (BrandId,Name) values (?,?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, model.getBrandId());
			query.setString(2, model.getName());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		sql="update models set BrandId=?,Name=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, model.getBrandId());
			query.setString(2, model.getName());
			query.setInt(3, model.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Model model) {
		// TODO Auto-generated method stub
    	sql="delete from models where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, model.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Model get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from models where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Model model=new Model(result.getInt("Id"),result.getInt("BrandId"),result.getString("Name"));
			
			return model;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Model> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from models";
		
		ObservableList<Model> model=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				model.add(new Model(result.getInt("Id"),result.getInt("BrandId"),result.getString("Name")));
				
			}
			
			return model;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}
}
