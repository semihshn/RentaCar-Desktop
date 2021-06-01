package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.business.abstracts.CarService;
import application.business.abstracts.CustomerService;
import application.business.abstracts.RentalService;
import application.business.abstracts.UserService;
import application.business.concretes.CarManager;
import application.business.concretes.CustomerManager;
import application.business.concretes.RentalManager;
import application.business.concretes.UserManager;
import application.controllers.addControllers.AddRentalController;
import application.controllers.updateControllers.UpdateCarController;
import application.dataAccess.concretes.HibernateCarDao;
import application.dataAccess.concretes.HibernateCustomerDao;
import application.dataAccess.concretes.HibernateRentalDao;
import application.dataAccess.concretes.HibernateUserDao;
import application.entities.DTOs.CarDetailDto;
import application.entities.concretes.Car;
import application.entities.concretes.LocalStorage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class CarsController {
	
	UserService userService=new UserManager(new HibernateUserDao());
	CarService carService=new CarManager(new HibernateCarDao());
	RentalService rentalService=new RentalManager(new HibernateRentalDao());
	CustomerService customerService=new CustomerManager(new HibernateCustomerDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox userVBox;

    @FXML
    private Label lbl_totalUsers;

    @FXML
    private VBox carVBox;

    @FXML
    private Label lbl_totalCars;

    @FXML
    private VBox rentalVBox;

    @FXML
    private Label lbl_totalRentals;

    @FXML
    private VBox customerVBox;

    @FXML
    private Label lbl_totalCustomers;

    @FXML
    private VBox pnItems;
    
    @FXML
    private TextField txt_search;
    
    @FXML
    private HBox hBox_buttons;
    
    @FXML
    void txt_searchKeyPress(KeyEvent event) {
		pnItems.getChildren().clear();
		
		String temp=txt_search.getText().toLowerCase();
		this.getTable(carService.getCarDetailsByName(temp));
    }
    
    public void getTable(List<CarDetailDto> car) {
    	
    	lbl_totalUsers.setText(String.valueOf(userService.getAll().size()));
    	lbl_totalCars.setText(String.valueOf(carService.getAll().size()));
    	lbl_totalRentals.setText(String.valueOf(rentalService.getAll().size()));
    	lbl_totalCustomers.setText(String.valueOf(customerService.getAll().size()));
    	
    	Node[] nodes = new Node[car.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Item.fxml"));
                nodes[i]=loader.load();
                ItemController item=loader.getController();
                item.setColumn(car.get(i).getCarname());
                item.setColumn(car.get(i).getColorName());
                item.setColumn(String.valueOf(car.get(i).getDailyPrice()));
                item.setColumn(String.valueOf(car.get(i).getModelYear()));
                item.setColumn(String.valueOf(car.get(i).getDescription()));
                
                for (String authority : LocalStorage.getAuthority()) {
					
                    if (authority.equals("admin")) {
    					
                    	item.setSuccessButton("Add", "../fxml/addPages/AddCar.fxml");
                        Button updateButton=item.setUpdateButton("Update",String.valueOf(car.get(i).getCarId()));

                        updateButton.setOnAction(event->{
                        	
                        	try {
                                FXMLLoader updatePageLoader = new FXMLLoader(getClass().getResource("../fxml/updatePages/UpdateCar.fxml"));
                                AnchorPane root = (AnchorPane)updatePageLoader.load();
                                
                                UpdateCarController updateController=updatePageLoader.getController();
                                
                                updateController.setSelected(String.valueOf(updateButton.getId()));
                    			
                    			Scene scene = new Scene(root,539,570);
                    			Stage primaryStage=new Stage();
                    			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
                    			primaryStage.setTitle("Update");
                    			primaryStage.setScene(scene);
                    			primaryStage.show();
                    		} catch(Exception e) {
                    			e.printStackTrace();
                    		}
                        	
                        });
                        
                        
                        Button deleteButton=item.setDangerButton("Delete");
                        deleteButton.setId(String.valueOf(car.get(i).getCarId()));
                        
                        deleteButton.setOnAction(event->{
                        	
                        	Car temp=carService.get(Integer.valueOf(updateButton.getId()));
                        	carService.delete(temp);
                        	pnItems.getChildren().clear();
                        	this.getTable(carService.getCarDetails());
                    		
                        });
                    	
    				} else if(authority.equals("member")){
    					
    					Button addButton=item.setSuccessButton("Rent it", "../fxml/addPages/AddCar.fxml");
    					addButton.setId(String.valueOf(car.get(i).getCarId()));
    					
    					addButton.setOnAction(event->{
    						
        					try {
        						
            					
            					FXMLLoader addPageLoader = new FXMLLoader(getClass().getResource("../fxml/addPages/AddRental.fxml"));
                                AnchorPane root = (AnchorPane)addPageLoader.load();
                                
                                AddRentalController addController=addPageLoader.getController();
                                
                                addController.setCarId(Integer.valueOf(addButton.getId()));
                    			
                    			Scene scene = new Scene(root,539,570);
                    			Stage primaryStage=new Stage();
                    			primaryStage.getIcons().add(new Image("file:src/application/images/logo.png"));
                    			primaryStage.setTitle("Rental");
                    			primaryStage.setScene(scene);
                    			primaryStage.show();
                    		} catch(Exception e) {
                    			e.printStackTrace();
                    		}
    						
    					});
    					

    					
    					
    				}
                	
				}
                

                
           
                //give the items some effect
                
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setAddButton() {

    }

    @FXML
    void initialize() {
    	this.getTable(carService.getCarDetails());
    	//this.setAddButton();

    }
}
