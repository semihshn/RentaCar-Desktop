package application.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.business.abstracts.AuthService;
import application.business.abstracts.UserService;
import application.business.concretes.AuthManager;
import application.business.concretes.UserManager;
import application.core.entitie.concretes.OperationClaim;
import application.core.entitie.concretes.User;
import application.dataAccess.concretes.HibernateUserDao;
import application.entities.concretes.LocalStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	
	AuthService authService=new AuthManager(new HibernateUserDao());
	UserService userService=new UserManager(new HibernateUserDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_userName;

    @FXML
    private PasswordField txt_psw;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    @FXML
    void btnLoginClicked(ActionEvent event) {
    		
    	User user=authService.Login(txt_userName.getText(), txt_psw.getText());
    	List<OperationClaim> operationClaim=userService.GetClaims(user);
    	
    	if (user!=null) {
    		
    		this.setLocalStorage(user,operationClaim);
    		for (int i = 0; i < operationClaim.size(); i++) {
    			
    			switch(operationClaim.get(i).getName()) {
    			  case "admin":
          			try {
                		
            			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../fxml/AdminPage.fxml"));
            			Scene scene = new Scene(root,1300,576);
            			Stage primaryStage=new Stage();
            			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
            			primaryStage.setTitle("Admin");
            			primaryStage.setScene(scene);
            			primaryStage.show();
            			
            			 Stage stage = (Stage) btn_register.getScene().getWindow();
            			 stage.close();
            			
            			
            		} catch(Exception e) {
            			e.printStackTrace();
            		}
    			    break;
    			  case "member":
          			try {
                		
            			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../fxml/UserPage.fxml"));
            			Scene scene = new Scene(root,1300,576);
            			Stage primaryStage=new Stage();
            			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
            			primaryStage.setTitle("User");
            			primaryStage.setScene(scene);
            			primaryStage.show();
            			
            			 Stage stage = (Stage) btn_register.getScene().getWindow();
            			 stage.close();
            			
            			
            		} catch(Exception e) {
            			e.printStackTrace();
            		}
    			    break;
    			  default:
    				  System.out.println("Kullanýcý yetkisi tanýmlanmamýþ");
    			}
				
			}
		} 
    	else 
    	{
			
			System.out.println("Kullanýcý adý veya þifre yanlýþ");
			
		}
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) {
    	try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../fxml/Register.fxml"));
			Scene scene = new Scene(root,450,550);
			Stage primaryStage=new Stage();
			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
			primaryStage.setTitle("Register");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			 Stage stage = (Stage) btn_register.getScene().getWindow();
			 stage.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void setLocalStorage(User user,List<OperationClaim> operationClaim) {
    	LocalStorage.setUserName(user.getFirstName()+" "+user.getLastName());
    	LocalStorage.setEmail(user.getEmail());
    	LocalStorage.setAge(user.getAge());
    	LocalStorage.setUserId(user.getId());
    	
    	for (OperationClaim claim : operationClaim) {
			LocalStorage.setAuthority(claim.getName());
		}
    }

    @FXML
    void initialize() {


    }
}
