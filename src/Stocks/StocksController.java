package Stocks;

import java.io.IOException;

import Admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StocksController extends AdminController {
	@FXML
	public void Logout(ActionEvent e) throws IOException {
			super.ShowHome(e);   	
	}
	@FXML
		public void StockLimit(ActionEvent e) {
		
		FxmlLoader5 object = new FxmlLoader5();
		view = object.getPage("Limit");
		borderpane.setCenter(view);
	}
	@FXML
	public void StockSearch(ActionEvent e) {
	
	FxmlLoader5 object = new FxmlLoader5();
	view = object.getPage("StockLimit");
	borderpane.setCenter(view);
}
		
}