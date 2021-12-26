package Doctor;

import java.io.IOException;

import Admin.AdminController;
import Admin.FxmlLoader1;
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
	@FXML
	private void ShowDash(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Dashboard");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowHist(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("PATIENTS_HIS");
		borderpane.setCenter(view);
	}
	
}
