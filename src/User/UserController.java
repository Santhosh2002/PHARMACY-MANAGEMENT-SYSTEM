package User;

import java.io.IOException;

import Admin.AdminController;
import Doctor.FxmlLoader4;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserController extends AdminController {
	@FXML
    public void Logout(ActionEvent e) throws IOException {
		super.ShowHome(e);   	
	}
	@FXML
	public void MyOrders(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Appointment");
		borderpane.setCenter(view);
	}
}
