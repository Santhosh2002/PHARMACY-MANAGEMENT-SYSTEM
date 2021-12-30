package Pharmacist;

import java.io.IOException;

import Admin.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PharmacistController extends AdminController {
	@FXML
	public void Logout(ActionEvent e) throws IOException {
		super.ShowHome(e);
	}

	@FXML
	public void Exit() {
		super.ExitApplication();

	}

	public void Sales(ActionEvent e) {

		FxmlLoader3 object1 = new FxmlLoader3();
		view = object1.getPage("Sales");
		borderpane.setCenter(view);
	}
	public void Stocks(ActionEvent e) {

		FxmlLoader3 object1 = new FxmlLoader3();
		view = object1.getPage("Managing_stocks");
		borderpane.setCenter(view);
	}
}