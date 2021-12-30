package Doctor;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DoctorController extends AdminController {

	@FXML
    public void Logout(ActionEvent e) throws IOException {
		super.ShowHomeA(e);   	
	}
	@FXML
    public void Exit() {
		super.ExitApplication();   	
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
	@FXML
	private void ShowTodayApp(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("D_Ptnt_Search");
		borderpane1.setCenter(view);
	}
	@FXML
	private void ShowPatientHist(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("D_Ptnt_list");
		borderpane1.setCenter(view);
	}
	

    @FXML
    private TableColumn<DoctorT, String> DOA;

   /* @FXML
    private TableColumn<DoctorT, String> DOB;*/

    @FXML
    private TableColumn<DoctorT, String> Email;

    @FXML
    private TableColumn<DoctorT, String> Gender;

    @FXML
    private TableColumn<DoctorT, String> M_num;

    @FXML
    private TableColumn<DoctorT, String> Name;

    @FXML
    private TableView<DoctorT> PatientTable;

    @FXML
    private TableColumn<DoctorT, Integer> Sno;

    @FXML
    private TableColumn<DoctorT, String> TimeOA;

    ObservableList<DoctorT> listM;
    int index = -1;
    @FXML
    public void Data() {
    	Sno.setCellValueFactory(new PropertyValueFactory<DoctorT,Integer>("Sno"));
     	//DOB.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("DOB"));
    	Email.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("Email"));
    	Name.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("Name"));
    	M_num.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("M_num"));
    	Gender.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("Gender"));
    	DOA.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("DOA"));
    	TimeOA.setCellValueFactory(new PropertyValueFactory<DoctorT,String>("TimeOA"));
    	
    	
    	listM = getDataPatient();
    	PatientTable.setItems(listM);
    }
    
    public ObservableList<DoctorT> getDataPatient(){
    	super.createconnection();
    	ObservableList<DoctorT> list= FXCollections.observableArrayList();
    	try {
    		PreparedStatement ps = con.prepareStatement("SELECT * FROM newpatientd");
    		ResultSet rs = ps.executeQuery();

    		
    		while(rs.next()) {
    			list.add(new DoctorT(Integer.parseInt(rs.getString("Id")),rs.getString("F_Name"),rs.getString("Email_id")
    			,rs.getString("M_Number"),rs.getString("gender"),rs.getString("dOA"),rs.getString("TOA")));	
    		}
    	}
    	catch(Exception e) {
    		
    	}
		return list;
    	
    }
    
    @FXML
    public void dashboardDoc() throws IOException {
    	super.Dashboard();
    }
}
