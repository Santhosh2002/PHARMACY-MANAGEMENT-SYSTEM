package User;

import java.io.IOException;

import Admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserController extends AdminController {
	@FXML
    public void Logout(ActionEvent e) throws IOException {
		super.ShowHome(e);   	
	}

}
