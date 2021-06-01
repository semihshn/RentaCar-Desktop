package application.controllers.addControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.CustomerService;
import application.business.abstracts.UserService;
import application.business.concretes.CustomerManager;
import application.business.concretes.UserManager;
import application.core.entitie.concretes.User;
import application.dataAccess.concretes.HibernateCustomerDao;
import application.dataAccess.concretes.HibernateUserDao;
import application.entities.concretes.Customer;
import application.helper.ConfigurationCombo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {
	
	UserService userService=new UserManager(new HibernateUserDao());
	CustomerService customerService=new CustomerManager(new HibernateCustomerDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_companyName;

    @FXML
    private TextField txt_findeks;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<ConfigurationCombo> combo_userName;

    @FXML
    void btn_cancelClicked(ActionEvent event) {
		 Stage stage = (Stage) btn_cancel.getScene().getWindow();
		 stage.close();
    }

    @FXML
    void btn_saveClicked(ActionEvent event) {
    	ConfigurationCombo temp = combo_userName.getSelectionModel().getSelectedItem();
    	
    	Customer customer=new Customer(temp.getId(),txt_companyName.getText(),Integer.valueOf(txt_findeks.getText()));
    	customerService.add(customer);
    	System.out.println("Customer ekleme iþlemi baþarýlý");
    }
    
    public void getComboValues() {
    	
    	ObservableList<ConfigurationCombo> users = FXCollections.observableArrayList();
    	
    	for (User user : userService.getAll()) {
			
    		users.addAll(new ConfigurationCombo(user.getId(), user.getFirstName()+" "+user.getLastName()));
    		
		}
    	
    	combo_userName.setItems(users);
    }

    @FXML
    void initialize() {
    	this.getComboValues();
    }
}
