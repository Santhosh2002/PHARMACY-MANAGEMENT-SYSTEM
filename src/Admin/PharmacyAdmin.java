package Admin;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.FxmlLoader;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class PharmacyAdmin extends Application {
    
	@FXML
	private BorderPane borderpane;
	Pane view;
	public Stage stage1;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage1 = primaryStage;
			Parent borderpane ;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
			borderpane = loader.load();
			Scene scene = new Scene(borderpane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
			
			FxmlLoader1 object = new FxmlLoader1();
			view = object.getPage("Dashboard");
			((BorderPane) borderpane).setCenter(view);
			
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
