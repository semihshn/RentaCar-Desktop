package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.dataAccess.abstracts.ColorDao;
import application.entities.concretes.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateColorDao implements ColorDao{
	
	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateColorDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Color color) {
		// TODO Auto-generated method stub
		sql="insert into colors (Name) values (?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, color.getName());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(Color color) {
		// TODO Auto-generated method stub
		sql="update colors set Name=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, color.getName());
			query.setInt(2, color.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Color color) {
		// TODO Auto-generated method stub
    	sql="delete from colors where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, color.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Color get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from colors where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Color color=new Color(result.getInt("Id"),result.getString("Name"));
			
			return color;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Color> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from colors";
		
		ObservableList<Color> color=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				color.add(new Color(result.getInt("Id"),result.getString("Name")));
				
			}
			
			return color;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

}
