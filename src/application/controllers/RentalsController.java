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
import application.dataAccess.concretes.HibernateCarDao;
import application.dataAccess.concretes.HibernateCustomerDao;
import application.dataAccess.concretes.HibernateRentalDao;
import application.dataAccess.concretes.HibernateUserDao;
import application.entities.DTOs.RentalDetailDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RentalsController {
	
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
    void initialize() {
    	List<RentalDetailDto> rental=rentalService.getRentalDetails();
    	
    	lbl_totalUsers.setText(String.valueOf(userService.getAll().size()));
    	lbl_totalCars.setText(String.valueOf(carService.getAll().size()));
    	lbl_totalRentals.setText(String.valueOf(rentalService.getAll().size()));
    	lbl_totalCustomers.setText(String.valueOf(customerService.getAll().size()));
    	
    	Node[] nodes = new Node[rental.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Item.fxml"));
                nodes[i]=loader.load();
                ItemController item=loader.getController();
                item.setColumn(rental.get(i).getCarName());
                item.setColumn(rental.get(i).getUserName());
                item.setColumn(rental.get(i).getCustomerName());
                item.setColumn(String.valueOf(rental.get(i).getRentDate()));
                item.setColumn(String.valueOf(rental.get(i).getReturnDate()));
                item.setColumn(String.valueOf(rental.get(i).getTotalPrice()));
           
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
}
