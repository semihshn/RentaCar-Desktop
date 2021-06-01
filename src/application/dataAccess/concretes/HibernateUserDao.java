package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import application.core.entitie.concretes.OperationClaim;
import application.core.entitie.concretes.User;
import application.dataAccess.abstracts.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateUserDao implements UserDao{

	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateUserDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		sql="insert into users (FirstName,LastName,Email,PasswordHash,Age) values (?,?,?,?,?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, user.getFirstName());
			query.setString(2, user.getLastName());
			query.setString(3, user.getEmail());
			query.setString(4, user.getPasswordHash());
			query.setDate(5, (Date)user.getAge());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		sql="update users set FirstName=?,LastName=?,Email=?,PasswordHash=?,Status=?,Age=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, user.getFirstName());
			query.setString(2, user.getLastName());
			query.setString(3, user.getEmail());
			query.setString(4, user.getPasswordHash());
			query.setBoolean(5, user.isStatus());
			query.setDate(6, (Date)user.getAge());
			query.setInt(7, user.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
    	sql="delete from users where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, user.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from users where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			User user=new User(result.getInt("Id"),result.getString("FirstName"),result.getString("LastName"),result.getString("Email"),result.getString("PasswordHash"),result.getBoolean("Status"),result.getDate("Age"));
			
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<User> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from users";
		
		ObservableList<User> user=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				user.add(new User(result.getInt("id"),result.getString("FirstName"),result.getString("LastName"),result.getString("Email"),result.getString("PasswordHash"),result.getBoolean("Status"),result.getDate("Age")));
				
			}
			
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public User login(String email, String passwordHash) {
		// TODO Auto-generated method stub
    	try {
    		sql="select * from users where Email=? AND PasswordHash=?";
			query=connection.prepareStatement(sql);
    		query.setString(1, email);
    		query.setString(2, passwordHash);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			User user=new User(result.getInt("Id"),result.getString("FirstName"),result.getString("LastName"),result.getString("Email"),result.getString("PasswordHash"),result.getBoolean("Status"),result.getDate("Age"));

			return user;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
			
		}
		
    	return null;
	}

	@Override
	public List<OperationClaim> GetClaims(User user) {
		// TODO Auto-generated method stub
		
				sql="SELECT operationclaims.Id as Id, operationclaims.Name as Name\r\n"
						+ "						FROM ((useroperationclaims INNER JOIN users\r\n"
						+ "						     ON useroperationclaims.UserId = users.Id)\r\n"
						+ "						     INNER JOIN operationclaims\r\n"
						+ "						     ON useroperationclaims.OperationClaimId = operationclaims.Id) \r\n"
						+ "                             WHERE useroperationclaims.UserId=?";
				
				ObservableList<OperationClaim> operationClaim=FXCollections.observableArrayList();
				
		    	try {
					query=connection.prepareStatement(sql);
					query.setInt(1, user.getId());
					
					ResultSet result=query.executeQuery();
					
					while (result.next()) {
						operationClaim.add(new OperationClaim(result.getInt("Id"),result.getString("Name")));
						
					}
					
					return operationClaim;
				} catch (Exception e) {
					// TODO: handle exception
					new Exception(e.getMessage());
				}
				
				return null;
	}

}
