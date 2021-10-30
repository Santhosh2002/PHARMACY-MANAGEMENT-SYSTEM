package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Pharmacy extends Application {
    
	@FXML
	private BorderPane borderpane;
	Pane view;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent borderpane ;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main1.fxml"));
			borderpane = loader.load();
			Scene scene = new Scene(borderpane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image("image (1).png");
			Controller mwc = loader.getController();
			
			FxmlLoader object = new FxmlLoader();
			view = object.getPage("Home1");
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
