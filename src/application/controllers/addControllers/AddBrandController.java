package application.controllers.addControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.BrandService;
import application.business.concretes.BrandManager;
import application.dataAccess.concretes.HibernateBrandDao;
import application.entities.concretes.Brand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBrandController {
	
	BrandService brandService=new BrandManager(new HibernateBrandDao());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_colorName;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    void btn_cancelClicked(ActionEvent event) {
		 Stage stage = (Stage) btn_cancel.getScene().getWindow();
		 stage.close();
    }

    @FXML
    void btn_saveClicked(ActionEvent event) {
    	Brand brand=new Brand(txt_colorName.getText());
    	brandService.add(brand);
    	System.out.println("Added Brand");
    	
    }

    @FXML
    void initialize() {
        assert txt_colorName != null : "fx:id=\"txt_colorName\" was not injected: check your FXML file 'AddBrand.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'AddBrand.fxml'.";
        assert btn_save != null : "fx:id=\"btn_save\" was not injected: check your FXML file 'AddBrand.fxml'.";

    }
}
