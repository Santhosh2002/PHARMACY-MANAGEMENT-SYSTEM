package Doctor;

import java.io.IOException;

import application.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DoctorController {
	private Stage stage;
	@FXML
	private BorderPane borderpane; 
	Pane view;
	@FXML
    public void ShowHome(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Pharmacy.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
		
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Home");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
}
