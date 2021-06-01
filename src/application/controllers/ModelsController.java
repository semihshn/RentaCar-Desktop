package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.business.abstracts.CarService;
import application.business.abstracts.CustomerService;
import application.business.abstracts.ModelService;
import application.business.abstracts.RentalService;
import application.business.abstracts.UserService;
import application.business.concretes.CarManager;
import application.business.concretes.CustomerManager;
import application.business.concretes.ModelManager;
import application.business.concretes.RentalManager;
import application.business.concretes.UserManager;
import application.dataAccess.concretes.HibernateCarDao;
import application.dataAccess.concretes.HibernateCustomerDao;
import application.dataAccess.concretes.HibernateModelDao;
import application.dataAccess.concretes.HibernateRentalDao;
import application.dataAccess.concretes.HibernateUserDao;
import application.entities.concretes.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ModelsController {
	
	UserService userService=new UserManager(new HibernateUserDao());
	CarService carService=new CarManager(new HibernateCarDao());
	RentalService rentalService=new RentalManager(new HibernateRentalDao());
	CustomerService customerService=new CustomerManager(new HibernateCustomerDao());

	ModelService modelService=new ModelManager(new HibernateModelDao());
	
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
    
    public void getTabel() {
    	List<Model> model=modelService.getAll();
    	
    	lbl_totalUsers.setText(String.valueOf(userService.getAll().size()));
    	lbl_totalCars.setText(String.valueOf(carService.getAll().size()));
    	lbl_totalRentals.setText(String.valueOf(rentalService.getAll().size()));
    	lbl_totalCustomers.setText(String.valueOf(customerService.getAll().size()));
    	
    	Node[] nodes = new Node[model.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Item.fxml"));
                nodes[i]=loader.load();
                ItemController item=loader.getController();
                item.setColumn(model.get(i).getName());
                item.setSuccessButton("Add", "../fxml/addPages/AddModel.fxml");
                
                
                Button deleteButton=item.setDangerButton("Delete");
                
                int id=model.get(i).getId();
                deleteButton.setOnAction(event->{
                	Model temp=modelService.get(id);
                	modelService.delete(temp);
                	pnItems.getChildren().clear();
                	this.getTabel();
                });
             
           
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
    
    @FXML
    void initialize() {
    	this.getTabel();
    }
}
