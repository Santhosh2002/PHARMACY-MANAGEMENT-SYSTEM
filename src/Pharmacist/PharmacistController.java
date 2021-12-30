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
}
