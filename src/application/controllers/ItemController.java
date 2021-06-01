package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.html.ImageView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox itemC;
    
    @FXML
    private ImageView imageView;
    
    public void setColumn(String content) {
        Label label=new Label(content);
        label.setTextFill(Color.web("#b7c3d7"));
        label.setFont(new Font("Regular", 12));
        label.setTextAlignment(TextAlignment.LEFT);  
        label.setPrefWidth(75);
        itemC.getChildren().add(label);
    }
    
    public Button setButton(String content) {
    	Button button=new Button(content);
    	button.setTextFill(Color.web("#000000"));
    	button.setFont(new Font("Regular", 12));
    	button.setTextAlignment(TextAlignment.RIGHT);  
    	button.setPrefWidth(100);
    	button.setPrefHeight(10);
    	button.setStyle("-fx-border-color: #2A73FF;-fx-border-radius: 20;-fx-background-color: transparent");
        itemC.getChildren().add(button);
        
        button.setOnMouseEntered(event->{
        	button.setStyle("-fx-border-color: #2A73FF;-fx-border-radius: 20;-fx-background-color: transparent;-fx-text-fill:#2A73FF;");
        });
        
        button.setOnMouseExited(event -> {
        	button.setStyle("-fx-border-color: #2A73FF;-fx-border-radius: 20;-fx-background-color: transparent");
        });
        
        return button;
    }
    
    public Button setSuccessButton(String content, String stagePath) {
    	
    	Button button=new Button(content);
    	button.setTextFill(Color.web("#000000"));
    	button.setFont(new Font("Regular", 12));
    	button.setTextAlignment(TextAlignment.RIGHT);  
    	button.setPrefWidth(100);
    	button.setPrefHeight(10);
    	button.setStyle("-fx-border-color: #145A32;-fx-border-radius: 20;-fx-background-color: transparent");
        itemC.getChildren().add(button);
        
        button.setOnMouseEntered(event->{
        	button.setStyle("-fx-border-color: #145A32;-fx-border-radius: 20;-fx-background-color: transparent;-fx-text-fill:#145A32;");
        });
        
        button.setOnMouseExited(event -> {
        	button.setStyle("-fx-border-color: #145A32;-fx-border-radius: 20;-fx-background-color: transparent");
        });
        
        button.setOnAction(event->{
        	try {
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(stagePath));
    			Scene scene = new Scene(root,539,570);
    			Stage primaryStage=new Stage();
    			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
    			primaryStage.setTitle("Add");
    			primaryStage.setScene(scene);
    			primaryStage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        });
        
        return button;
    }
    
    public Button setUpdateButton(String content,String carId) {
    	Button button=new Button(content);
    	button.setId(carId);
    	button.setTextFill(Color.web("#000000"));
    	button.setFont(new Font("Regular", 12));
    	button.setTextAlignment(TextAlignment.RIGHT);  
    	button.setPrefWidth(100);
    	button.setPrefHeight(10);
    	button.setStyle("-fx-border-color: #FFFF00;-fx-border-radius: 20;-fx-background-color: transparent");
        itemC.getChildren().add(button);
        
        
        button.setOnMouseEntered(event->{
        	button.setStyle("-fx-border-color: #FFFF00;-fx-border-radius: 20;-fx-background-color: transparent;-fx-text-fill:#FFFF00;");
        });
        
        button.setOnMouseExited(event -> {
        	button.setStyle("-fx-border-color: #FFFF00;-fx-border-radius: 20;-fx-background-color: transparent");
        });
        
        return button;
    }
    
    public Button setDangerButton(String content) {
    	Button button=new Button(content);
    	button.setTextFill(Color.web("#000000"));
    	button.setFont(new Font("Regular", 12));
    	button.setTextAlignment(TextAlignment.RIGHT);  
    	button.setPrefWidth(100);
    	button.setPrefHeight(10);
    	button.setStyle("-fx-border-color: #7B241C;-fx-border-radius: 20;-fx-background-color: transparent");
        itemC.getChildren().add(button);
        
        
        button.setOnMouseEntered(event->{
        	button.setStyle("-fx-border-color: #7B241C;-fx-border-radius: 20;-fx-background-color: transparent;-fx-text-fill:#7B241C;");
        });
        
        button.setOnMouseExited(event -> {
        	button.setStyle("-fx-border-color: #7B241C;-fx-border-radius: 20;-fx-background-color: transparent");
        });
        
        return button;
    }
    
    @FXML
    void initialize() {

    }
}
