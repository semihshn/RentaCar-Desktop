package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import application.dataAccess.abstracts.RentalDao;
import application.entities.DTOs.RentalDetailDto;
import application.entities.concretes.Rental;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateRentalDao implements RentalDao{
	
	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateRentalDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Rental rental) {
		// TODO Auto-generated method stub
		sql="insert into rentals (CarId,CustomerId,RentDate,ReturnDate) values (?,?,?,?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, rental.getCarId());
			query.setInt(2, rental.getCustomerId());
			query.setDate(3, (Date)rental.getRentDate());
			query.setDate(4, (Date)rental.getReturnDate());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
		
	}

	@Override
	public void update(Rental rental) {
		// TODO Auto-generated method stub
		sql="update rentals set CarId=?,CustomerId=?,RentDate=?,ReturnDate=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, rental.getCarId());
			query.setInt(2, rental.getCustomerId());
			query.setDate(3, rental.getRentDate());
			query.setDate(4, rental.getReturnDate());
			query.setInt(5, rental.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Rental rental) {
		// TODO Auto-generated method stub
    	sql="delete from rentals where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, rental.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Rental get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from rentals where id=?";
			query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Rental rental=new Rental(result.getInt("Id"),result.getInt("CarId"),result.getInt("CustomerId"),result.getDate("RentDate"),result.getDate("ReturnDate"));
			
			return rental;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Rental> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from rentals";
		
		ObservableList<Rental> rental=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				rental.add(new Rental(result.getInt("Id"),result.getInt("CarId"),result.getInt("CustomerId"),result.getDate("RentDate"),result.getDate("ReturnDate")));
				
			}
			
			return rental;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<RentalDetailDto> getRentalDetails() {
		// TODO Auto-generated method stub
		sql="SELECT rentals.Id as RentalId,cars.Id as CarId, brands.Name as CarName , customers.CompanyName as CustomerName,\r\n"
				+ "CONCAT(users.FirstName, ' ', users.LastName) as UserName,rentals.RentDate as RentDate,rentals.ReturnDate as ReturnDate,\r\n"
				+ "(Day(rentals.ReturnDate)-Day(rentals.RentDate))*cars.DailyPrice as TotalPrice \r\n"
				+ "FROM ((rentals INNER JOIN cars \r\n"
				+ "       ON rentals.CarId = cars.Id)\r\n"
				+ "      INNER JOIN customers \r\n"
				+ "      ON rentals.CustomerId=customers.Id)\r\n"
				+ "      INNER JOIN brands \r\n"
				+ "      ON cars.BrandId=brands.Id\r\n"
				+ "      INNER JOIN users \r\n"
				+ "      ON customers.UserId=users.Id";
		
		ObservableList<RentalDetailDto> rentalDetailDto=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				rentalDetailDto.add(new RentalDetailDto(result.getInt("RentalId"),result.getInt("CarId"),result.getString("CarName"),result.getString("UserName"),result.getString("CustomerName"),result.getDate("RentDate"),result.getDate("ReturnDate"),result.getInt("TotalPrice")));
				
			}
			
			return rentalDetailDto;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}
	
}
