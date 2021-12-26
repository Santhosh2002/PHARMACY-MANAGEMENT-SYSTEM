package application;
	
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
	Pane view;
	
	@FXML
	private BorderPane borderpane;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent borderpane ;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Pharmacy.fxml"));
			borderpane = loader.load();
			Scene scene = new Scene(borderpane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image("\\Images\\logo.png");
			
			FxmlLoader object = new FxmlLoader();
			view = object.getPage("Home");
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
