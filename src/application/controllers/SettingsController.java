package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.AuthService;
import application.business.abstracts.UserService;
import application.business.concretes.AuthManager;
import application.business.concretes.UserManager;
import application.core.entitie.concretes.User;
import application.core.utilities.security.encryption.EncryptHelper;
import application.dataAccess.concretes.HibernateUserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SettingsController {
	
	AuthService authService=new AuthManager(new HibernateUserDao());
	UserService userService=new UserManager(new HibernateUserDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_currentPassword;

    @FXML
    private PasswordField txt_newPassword;

    @FXML
    private PasswordField txt_confirmPassword;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    void btn_saveAction(ActionEvent event) {
    	
    	User user=authService.Login(txt_email.getText(), txt_currentPassword.getText());
    	
    	if (user!=null) {
			System.out.println(txt_newPassword.getText());
			System.out.println(txt_confirmPassword.getText());
    		if (txt_newPassword.getText()==txt_confirmPassword.getText()) {
    			String encrypted=EncryptHelper.encryptMD5(txt_newPassword.getText());
				user.setPasswordHash(encrypted);
				userService.update(user);
				System.out.println("Þifre deðiþtirildi");
			} else {
				System.out.println("Þifre tekrarýný yanlýþ girdiniz");
			}
    		
		} else {
			System.out.println("Kullanýcý adý veya þifrenizi yanlýþ girdiniz");
		}
    	
    }

    @FXML
    void initialize() {

    }
}
