package Pharmacist;

import java.io.IOException;

import Admin.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PharmacistController extends AdminController {
	@FXML
	public void Logout(ActionEvent e) throws IOException {
		super.ShowHomeA(e);
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
		view = object1.getPage("ManageStock");
		borderpane.setCenter(view);
	}
	public void ManageStocks(ActionEvent e) {

		FxmlLoader3 object1 = new FxmlLoader3();
		view = object1.getPage("Managaingstocks");
		borderpane.setCenter(view);
	}
	@FXML
    public void dashboardPhar() throws IOException {
    	super.Dashboard();
    }
}