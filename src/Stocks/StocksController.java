package Stocks;

import java.io.IOException;

import Admin.AdminController;
import application.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StocksController extends AdminController {
	@FXML
	public void Logout(ActionEvent e) throws IOException {
			super.ShowHomeA(e);   	
	}
	@FXML
		public void StockLimit(ActionEvent e) {
		
		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Limit");
		borderpane.setCenter(view);
	}
	@FXML
	public void MedicineDetails(ActionEvent e) {
	
	FxmlLoader5 object = new FxmlLoader5();
	view = object.getPage("Med_Details");
	borderpane.setCenter(view);
    }
	@FXML
	public void MDetails(ActionEvent e) {

		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Details");
		borderpane.setCenter(view);
	}

	@FXML
	public void Stocks(ActionEvent e) {
	
	FxmlLoader5 object = new FxmlLoader5();
	view = object.getPage("Stock");
	borderpane.setCenter(view);

}
	@FXML
	public void StockSearch(ActionEvent e) {

		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("StockLimit");
		borderpane.setCenter(view);
	}
	@FXML
	public void ExpiryProducts(ActionEvent e) {

		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Exp_Products");
		borderpane.setCenter(view);

	}
	@FXML
	public void NearExpiry(ActionEvent e) {
		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Nexp_Products");
		borderpane.setCenter(view);
	}
	@FXML
	public void StockShortage(ActionEvent e) {
		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Shortage");
		borderpane.setCenter(view);
	}

	@FXML
	public void BackToAdmin(ActionEvent e) throws IOException {

		Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/Admin.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("\\Images\\logo.png");


		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Dashboard");
		((BorderPane) borderpane).setCenter(view);

		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	}