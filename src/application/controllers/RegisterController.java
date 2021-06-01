package application.controllers;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import application.business.abstracts.AuthService;
import application.business.concretes.AuthManager;
import application.dataAccess.concretes.HibernateUserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {
	
	AuthService authService=new AuthManager(new HibernateUserDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_firstName;

    @FXML
    private TextField txt_lastName;

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button btn_register;

    @FXML
    void btn_registerClick(ActionEvent event) {
    	
    	boolean result=authService.Register(txt_firstName.getText(), txt_lastName.getText(), txt_email.getText(), txt_password.getText(), true, Date.valueOf(datePicker.getValue()));
    	if (result) {
			
        	try {
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../fxml/Login.fxml"));
    			Scene scene = new Scene(root,700,400);
    			Stage primaryStage=new Stage();
    			primaryStage.setScene(scene);
    			primaryStage.show();
    			
    			 Stage stage = (Stage) btn_register.getScene().getWindow();
    			 stage.close();
    			
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    		
		} else {

			System.out.println("Kayýt yapýlamadý");
			
		}
    	
  
    }

    @FXML
    void initialize() {
        assert txt_firstName != null : "fx:id=\"txt_firstName\" was not injected: check your FXML file 'Register.fxml'.";
        assert txt_lastName != null : "fx:id=\"txt_lastName\" was not injected: check your FXML file 'Register.fxml'.";
        assert txt_email != null : "fx:id=\"txt_email\" was not injected: check your FXML file 'Register.fxml'.";
        assert txt_password != null : "fx:id=\"txt_password\" was not injected: check your FXML file 'Register.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'Register.fxml'.";
        assert btn_register != null : "fx:id=\"btn_register\" was not injected: check your FXML file 'Register.fxml'.";

    }
}
