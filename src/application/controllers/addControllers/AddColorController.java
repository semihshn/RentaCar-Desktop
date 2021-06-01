package application.controllers.addControllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.abstracts.ColorService;
import application.business.concretes.ColorManager;
import application.dataAccess.concretes.HibernateColorDao;
import application.entities.concretes.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddColorController {
	
	ColorService colorService=new ColorManager(new HibernateColorDao());

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

    	Color color=new Color(txt_colorName.getText());
    	colorService.add(color);
    	System.out.println("Added Color");
    	
    }

    @FXML
    void initialize() {
        assert txt_colorName != null : "fx:id=\"txt_colorName\" was not injected: check your FXML file 'AddColor.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'AddColor.fxml'.";
        assert btn_save != null : "fx:id=\"btn_save\" was not injected: check your FXML file 'AddColor.fxml'.";

    }
}
