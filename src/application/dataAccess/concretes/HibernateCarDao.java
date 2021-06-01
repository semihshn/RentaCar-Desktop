package application.dataAccess.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import application.dataAccess.abstracts.CarDao;
import application.entities.DTOs.CarDetailDto;
import application.entities.concretes.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateCarDao implements CarDao{
	
	Connection connection=null;
    PreparedStatement query=null;
    ResultSet result=null;
    String sql;
    
	public HibernateCarDao() {
		// TODO Auto-generated constructor stub
		connection=Context.Connect();
	}
	
	@Override
	public void add(Car car) {
		// TODO Auto-generated method stub
		sql="insert into cars (ModelId,BrandId,ColorId,DailyPrice,ModelYear,Description,FindeksScore) values (?,?,?,?,?,?,?)";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, car.getModelId());
			query.setInt(2, car.getBrandId());
			query.setInt(3, car.getColorId());
			query.setInt(4, car.getDailyPrice());
			query.setInt(5, car.getModelYear());
			query.setString(6, car.getDescription());
			query.setInt(7, car.getFindeksScore());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		sql="update cars set ModelId=?,BrandId=?,ColorId=?,DailyPrice=?,ModelYear=?,Description=?,FindeksScore=? where Id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, car.getModelId());
			query.setInt(2, car.getBrandId());
			query.setInt(3, car.getColorId());
			query.setInt(4, car.getDailyPrice());
			query.setInt(5, car.getModelYear());
			query.setString(6, car.getDescription());
			query.setInt(7, car.getFindeksScore());
			query.setInt(8, car.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public void delete(Car car) {
		// TODO Auto-generated method stub
    	sql="delete from cars where id=?";
    	try {
			query=connection.prepareStatement(sql);
			query.setInt(1, car.getId());
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e);
		}
	}

	@Override
	public Car get(int id) {
		// TODO Auto-generated method stub
		
    	try {
    		sql="select * from cars where id=?";
    		query=connection.prepareStatement(sql);
    		query.setInt(1, id);
			
			ResultSet result=query.executeQuery();
			result.next();
			
			Car car=new Car(result.getInt("Id"),result.getInt("ModelId"),result.getInt("BrandId"),result.getInt("ColorId"),result.getInt("DailyPrice"),result.getInt("ModelYear"),result.getString("Description"),result.getInt("FindeksScore"));
			
			return car;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public ObservableList<Car> getAll() {
		// TODO Auto-generated method stub
		
		sql="select * from cars";
		
		ObservableList<Car> car=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				car.add(new Car(result.getInt("Id"),result.getInt("ModelId"),result.getInt("BrandId"),result.getInt("ColorId"),result.getInt("DailyPrice"),result.getInt("ModelYear"),result.getString("Description"),result.getInt("FindeksScore")));
				
			}
			
			return car;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<CarDetailDto> getCarDetails() {
		// TODO Auto-generated method stub
				sql="SELECT cars.Id as CarId, CONCAT(brands.Name, ' ', models.Name) as CarName , models.Name as ModelName , brands.Name as BrandName,colors.Name as ColorName,cars.DailyPrice as DailyPrice,cars.Description as Description,cars.ModelYear as ModelYear \r\n"
						+ "FROM ((cars INNER JOIN colors \r\n"
						+ "       ON cars.ColorId = colors.Id)\r\n"
						+ "      INNER JOIN brands \r\n"
						+ "      ON cars.BrandId = brands.Id)\r\n"
						+ "      INNER JOIN models \r\n"
						+ "      ON cars.ModelId = models.Id";
				
				ObservableList<CarDetailDto> carDetailDto=FXCollections.observableArrayList();
				
		    	try {
					query=connection.prepareStatement(sql);
					
					ResultSet result=query.executeQuery();
					
					while (result.next()) {
						carDetailDto.add(new CarDetailDto(result.getInt("CarId"),result.getString("CarName"),result.getString("ModelName"),result.getString("BrandName"),result.getString("ColorName"),result.getInt("DailyPrice"),result.getInt("ModelYear"),result.getString("Description")));
						
					}
					
					return carDetailDto;
				} catch (Exception e) {
					// TODO: handle exception
					new Exception(e.getMessage());
				}
				
				return null;
	}

	@Override
	public List<CarDetailDto> getCarDetailsByName(String carName) {
		// TODO Auto-generated method stub
		sql="SELECT cars.Id as CarId, CONCAT(brands.Name, ' ', models.Name) as CarName , models.Name as ModelName , brands.Name as BrandName,colors.Name as ColorName,cars.DailyPrice as DailyPrice,cars.Description as Description,cars.ModelYear as ModelYear\r\n"
				+ "				FROM ((cars INNER JOIN colors\r\n"
				+ "				ON cars.ColorId = colors.Id)\r\n"
				+ "				INNER JOIN brands\r\n"
				+ "				ON cars.BrandId = brands.Id)\r\n"
				+ "				INNER JOIN models\r\n"
				+ "				ON cars.ModelId = models.Id WHERE CONCAT(brands.Name, ' ', models.Name) LIKE ?";
		
		ObservableList<CarDetailDto> carDetailDto=FXCollections.observableArrayList();
		
    	try {
			query=connection.prepareStatement(sql);
			query.setString(1, "%"+carName+"%");
			
			ResultSet result=query.executeQuery();
			
			while (result.next()) {
				carDetailDto.add(new CarDetailDto(result.getInt("CarId"),result.getString("CarName"),result.getString("ModelName"),result.getString("BrandName"),result.getString("ColorName"),result.getInt("DailyPrice"),result.getInt("ModelYear"),result.getString("Description")));
				
			}
			
			return carDetailDto;
		} catch (Exception e) {
			// TODO: handle exception
			new Exception(e.getMessage());
		}
		
		return null;
	}

	@Override
	public CarDetailDto getCarDetailsByCarId(int carId) {
		// TODO Auto-generated method stub
				sql="SELECT cars.Id as CarId, CONCAT(brands.Name, ' ', models.Name) as CarName , models.Name as ModelName , brands.Name as BrandName,colors.Name as ColorName,cars.DailyPrice as DailyPrice,cars.Description as Description,cars.ModelYear as ModelYear\r\n"
						+ "				FROM ((cars INNER JOIN colors\r\n"
						+ "				ON cars.ColorId = colors.Id)\r\n"
						+ "				INNER JOIN brands\r\n"
						+ "				ON cars.BrandId = brands.Id)\r\n"
						+ "				INNER JOIN models\r\n"
						+ "				ON cars.ModelId = models.Id WHERE cars.Id=?";
				
				
		    	try {
					query=connection.prepareStatement(sql);
					query.setInt(1, carId);
					
					ResultSet result=query.executeQuery();
					result.next();
					
					CarDetailDto carDetail=new CarDetailDto(result.getInt("CarId"),result.getString("CarName"),result.getString("ModelName"),result.getString("BrandName"),result.getString("ColorName"),result.getInt("DailyPrice"),result.getInt("ModelYear"),result.getString("Description"));
						
					
					
					return carDetail;
				} catch (Exception e) {
					// TODO: handle exception
					new Exception(e.getMessage());
				}
				
				return null;
	}

}
