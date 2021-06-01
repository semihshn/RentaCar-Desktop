package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.entities.concretes.LocalStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_userName;

    @FXML
    private Button btnCars;

    @FXML
    private Button btnBrands;

    @FXML
    private Button btnModels;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private AnchorPane anchorRoot;

    @FXML
    private Label lbl_totalCars;

    @FXML
    private Label lbl_totalBrands;

    @FXML
    private Label lbl_totalRentals;

    @FXML
    private Label lbl_totalCustomers;

    @FXML
    private VBox pnItems;

    @FXML
    private HBox hBox_buttons;

    @FXML
    void handleClicks(ActionEvent event) {
    	
        if(event.getSource()==btnCars)
        {
        	try {
        		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("../fxml/Cars.fxml")));
        		anchorRoot.getChildren().setAll(panel1);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        if (event.getSource() == btnBrands) {
        	try {
        		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("../fxml/Brands.fxml")));
        		anchorRoot.getChildren().setAll(panel1);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        if (event.getSource() == btnModels) {
        	try {
        		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("../fxml/Models.fxml")));
        		anchorRoot.getChildren().setAll(panel1);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        if (event.getSource() == btnSettings) {
        	try {
        		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("../fxml/Settings.fxml")));
        		anchorRoot.getChildren().setAll(panel1);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        if (event.getSource() == btnSignout) {
   		 Stage stage = (Stage) btnSignout.getScene().getWindow();
   		 stage.close();
        	
    		try {
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../fxml/Login.fxml"));
    			Scene scene = new Scene(root,700,400);
    			Stage primaryStage=new Stage();
    			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
    			primaryStage.setTitle("Login");
    			primaryStage.setScene(scene);
    			primaryStage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        }
    	
    }

    @FXML
    void initialize() {
    	lbl_userName.setText(LocalStorage.getUserName());
    	
    	try {
    		AnchorPane panel1=(AnchorPane) FXMLLoader.load(getClass().getResource(("../fxml/Cars.fxml")));
    		anchorRoot.getChildren().setAll(panel1);
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    }
}
