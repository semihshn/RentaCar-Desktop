package application.controllers.addControllers;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import application.business.abstracts.CustomerService;
import application.business.abstracts.RentalService;
import application.business.concretes.CustomerManager;
import application.business.concretes.RentalManager;
import application.dataAccess.concretes.HibernateCustomerDao;
import application.dataAccess.concretes.HibernateRentalDao;
import application.entities.concretes.Customer;
import application.entities.concretes.LocalStorage;
import application.entities.concretes.Rental;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class AddRentalController {
	
	CustomerService customerService=new CustomerManager(new HibernateCustomerDao());
	RentalService rentalService=new RentalManager(new HibernateRentalDao());
	
	int carId;
	Customer customer=customerService.getByUserId(LocalStorage.getUserId());
	
	public void setCarId(int carId) {
		this.carId=carId;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private DatePicker date_rentDate;

    @FXML
    private DatePicker date_returnDate;

    @FXML
    void btn_cancelClicked(ActionEvent event) {
    	
		 Stage stage = (Stage) btn_cancel.getScene().getWindow();
		 stage.close();
    	
    }

    @FXML
    void btn_saveClicked(ActionEvent event) {
    	if (customer==null) {
			
    		System.out.println("Þirketi olmayana araba yok");
    		
		} else {

    		try {
            	Date selectedRentDate=Date.valueOf(date_rentDate.getValue());
            	Date selectedReturnDate=Date.valueOf(date_returnDate.getValue());
            	
            	Rental rental=new Rental(this.carId,customer.getId(),selectedRentDate,selectedReturnDate);
            	
            	rentalService.add(rental);
            	
            	System.out.println("Araç kiralama iþlemi baþarýlý");
    			
    		} catch (Exception e) {
    			// TODO: handle exception
    			System.out.println(e.getMessage());
    		}
			
		}
    	
    	
    }

    @FXML
    void initialize() {
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'AddRental.fxml'.";
        assert btn_save != null : "fx:id=\"btn_save\" was not injected: check your FXML file 'AddRental.fxml'.";
        assert date_rentDate != null : "fx:id=\"date_rentDate\" was not injected: check your FXML file 'AddRental.fxml'.";
        assert date_returnDate != null : "fx:id=\"date_returnDate\" was not injected: check your FXML file 'AddRental.fxml'.";

    }
}
