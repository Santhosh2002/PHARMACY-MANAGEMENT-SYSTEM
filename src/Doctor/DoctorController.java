package Doctor;

import java.io.IOException;

import Admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DoctorController extends AdminController {

	@FXML
    public void Logout(ActionEvent e) throws IOException {
		super.ShowHome(e);   	
	}
	@FXML
	public void Appointments(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Appointment");
		borderpane.setCenter(view);
	}
	
}
