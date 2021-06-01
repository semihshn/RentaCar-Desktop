package application.controllers.addControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.BrandService;
import application.business.abstracts.CarService;
import application.business.abstracts.ColorService;
import application.business.abstracts.ModelService;
import application.business.concretes.BrandManager;
import application.business.concretes.CarManager;
import application.business.concretes.ColorManager;
import application.business.concretes.ModelManager;
import application.dataAccess.concretes.HibernateBrandDao;
import application.dataAccess.concretes.HibernateCarDao;
import application.dataAccess.concretes.HibernateColorDao;
import application.dataAccess.concretes.HibernateModelDao;
import application.entities.concretes.Brand;
import application.entities.concretes.Car;
import application.entities.concretes.Color;
import application.entities.concretes.Model;
import application.helper.ConfigurationCombo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCarController {
	
	BrandService brandService=new BrandManager(new HibernateBrandDao());
	ColorService colorService=new ColorManager(new HibernateColorDao());
	ModelService modelService=new ModelManager(new HibernateModelDao());
	CarService carService=new CarManager(new HibernateCarDao());
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_dailyPrice;

    @FXML
    private TextField txt_modelYear;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<ConfigurationCombo> combo_colorId;

    @FXML
    private ComboBox<ConfigurationCombo> combo_brandId;

    @FXML
    private ComboBox<ConfigurationCombo> combo_modelId;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_findeksScore;

    @FXML
    void btn_cancelClicked(ActionEvent event) {
		 Stage stage = (Stage) btn_cancel.getScene().getWindow();
		 stage.close();
    }

    @FXML
    void btn_saveClicked(ActionEvent event) {
    	
    	try {
    		ConfigurationCombo combModel = combo_modelId.getSelectionModel().getSelectedItem();
    		ConfigurationCombo combBrand = combo_brandId.getSelectionModel().getSelectedItem();
    		ConfigurationCombo combColor = combo_colorId.getSelectionModel().getSelectedItem();
    		
        	int dailyPrice=Integer.valueOf(txt_dailyPrice.getText());
        	int modelYear=Integer.valueOf(txt_modelYear.getText());
        	String description=txt_description.getText();
        	int findeksScore=Integer.valueOf(txt_findeksScore.getText());
        	
        	Car car=new Car(combModel.getId(),combBrand.getId(),combColor.getId(),dailyPrice,modelYear,description,findeksScore);
        	
        	carService.add(car);
        	
        	System.out.println("Kayýt yapýldý");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    	

    	
    }
    
    public void setBrand() {
    	ObservableList<ConfigurationCombo> brands = FXCollections.observableArrayList();
    	
    	for (Brand brand : brandService.getAll()) {
			
    		brands.addAll(new ConfigurationCombo(brand.getId(), brand.getName()));
    		
		}
    	
    	combo_brandId.setItems(brands);
    	
    }
    
    public void setColor() {
    	
    	ObservableList<ConfigurationCombo> colors = FXCollections.observableArrayList();
    	
    	for (Color color : colorService.getAll()) {
			
    		colors.addAll(new ConfigurationCombo(color.getId(), color.getName()));
    		
		}
    	
    	combo_colorId.setItems(colors);
    	
    }
    
    public void setModel() {
    	
    	ObservableList<ConfigurationCombo> models = FXCollections.observableArrayList();
    	
    	for (Model model : modelService.getAll()) {
			
    		models.addAll(new ConfigurationCombo(model.getId(), model.getName()));
    		
		}
    	
    	combo_modelId.setItems(models);
    	
    }

    @FXML
    void initialize() {
    	this.setBrand();
    	this.setColor();
    	this.setModel();
    }
}
