package application.controllers.addControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.BrandService;
import application.business.abstracts.ModelService;
import application.business.concretes.BrandManager;
import application.business.concretes.ModelManager;
import application.dataAccess.concretes.HibernateBrandDao;
import application.dataAccess.concretes.HibernateModelDao;
import application.entities.concretes.Brand;
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

public class AddModelController {
	
	BrandService brandService=new BrandManager(new HibernateBrandDao());
	ModelService modelService=new ModelManager(new HibernateModelDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_modelName;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;
    
    @FXML
    private ComboBox<ConfigurationCombo> combo_brandId;

    @FXML
    void btn_cancelClicked(ActionEvent event) {
		 Stage stage = (Stage) btn_cancel.getScene().getWindow();
		 stage.close();
    }

    @FXML
    void btn_saveClicked(ActionEvent event) {
    	
    	ConfigurationCombo combBrand = combo_brandId.getSelectionModel().getSelectedItem();

    	Model model=new Model(combBrand.getId(),txt_modelName.getText());
    	modelService.add(model);
    	System.out.println("Added Model");
    	
    }
    
    public void setBrand() {
    	ObservableList<ConfigurationCombo> brands = FXCollections.observableArrayList();
    	
    	for (Brand brand : brandService.getAll()) {
			
    		brands.addAll(new ConfigurationCombo(brand.getId(), brand.getName()));
    		
		}
    	
    	combo_brandId.setItems(brands);
    	
    }

    @FXML
    void initialize() {
    	this.setBrand();

    }
}
