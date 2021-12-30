package Admin;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import application.Controller;
import application.FxmlLoader;

public class AdminController extends Controller {
	
	protected Stage stage;
	@FXML
	protected BorderPane borderpane; 
	@FXML
	protected BorderPane borderpane1; 
	@FXML
	protected Text Date;
	@FXML
	protected Text Time;
	@FXML
	public ProgressBar P1;
	@FXML
	public ProgressBar P2;
	@FXML
	public ProgressBar P3;
	@FXML
	public ProgressBar P4;
	@FXML
	public ProgressBar P5;
	
	protected Pane view;
	Pane view1;
	
	@FXML
	private void ShowManageP(ActionEvent e) throws IOException {
		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManagePharmacist.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManagePharmacist");
		borderpane.setCenter(view);
		
		view1 = object1.getPage("MP-Add");
		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	private void ShowDoctorP(ActionEvent e) throws IOException {
//		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManageDoctor.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
//		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManageDoctor");
		borderpane.setCenter(view);
		
//		view1 = object1.getPage("MP-Add1");
//		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	private void ShowDash(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("Dashboard");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowAdd(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MP-Add");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowAddDoc(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MD-Add");
		borderpane.setCenter(view);
	}
	
	
	@FXML
	private void Addtolist(ActionEvent e) {

		super.Apply(e);
	}
	@FXML
	private void Re(ActionEvent e) {

		super.Reset2(e);
	}
	@FXML
    public void ShowStocks(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Stocks/Admin.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("\\Images\\logo.png");
		
		
//		FxmlLoader object = new FxmlLoader();
//		view = object.getPage("Dashboard");
//		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	@FXML
    public void ShowHomeA(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Pharmacy.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("\\Images\\logo.png");
		
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Home");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
	@FXML
	private void ShowBookedMed(ActionEvent e) throws IOException {
//		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/Booked_Med.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
//		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("Booked_Med");
		borderpane.setCenter(view);

//		view1 = object1.getPage("MP-Add1");
//		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	private void ShowViewList(ActionEvent e) {

		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("View_List");
		borderpane.setCenter(view);

	}
	@FXML
	private void ShowPatientsList(ActionEvent e) {

		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("Check_Patients");
		borderpane.setCenter(view);

	}
	@FXML
	private void ShowMedicineP(ActionEvent e) throws IOException {
//		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManageDoctor.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
//		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManageMedicines");
		borderpane.setCenter(view);
		
//		view1 = object1.getPage("MP-Add1");
//		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	public void ExitApplication() {
	    Platform.exit();
	}

//      @FXML
//      private TableColumn<PharmacistT, Date> C_DOB;

      @FXML
      private TableColumn<PharmacistT, String> C_Email;

      @FXML
      private TableColumn<PharmacistT, String> C_F_name;

      @FXML
      private TableColumn<PharmacistT, String> C_L_name;

      @FXML
      private TableColumn<PharmacistT, String> C_M_num;

      @FXML
      private TableView<PharmacistT> PharmacistTable;

      @FXML
      private TableColumn<PharmacistT, String> C_QualificationP;

      @FXML
      private TableColumn<PharmacistT, Integer> C_Sno;
    
    ObservableList<PharmacistT> listM;
    int index = -1;
    @FXML
    public void Data() {
    	C_Sno.setCellValueFactory(new PropertyValueFactory<PharmacistT,Integer>("Sno"));
//    	C_DOB.setCellValueFactory(new PropertyValueFactory<PharmacistT,Date>("DOBP"));
    	C_Email.setCellValueFactory(new PropertyValueFactory<PharmacistT,String>("Email"));
    	C_F_name.setCellValueFactory(new PropertyValueFactory<PharmacistT,String>("F_name"));
    	C_L_name.setCellValueFactory(new PropertyValueFactory<PharmacistT,String>("L_name"));
    	C_M_num.setCellValueFactory(new PropertyValueFactory<PharmacistT,String>("M_num"));
    	C_QualificationP.setCellValueFactory(new PropertyValueFactory<PharmacistT,String>("QualificationP"));
    	
    	listM = getDataPharmacist();
    	PharmacistTable.setItems(listM);
    }
    
    public ObservableList<PharmacistT> getDataPharmacist(){
    	super.createconnection();
    	ObservableList<PharmacistT> list= FXCollections.observableArrayList();
    	try {
    		PreparedStatement ps = con.prepareStatement("SELECT * FROM newpharmacistd");
    		ResultSet rs = ps.executeQuery();

    		
    		while(rs.next()) {
    			list.add(new PharmacistT(Integer.parseInt(rs.getString("Id"))
    			,Integer.parseInt(rs.getString("M_NumberP")),rs.getString("F_NameP"),rs.getString("L_NameP")
    			,rs.getString("Email_idP"),rs.getString("QualificationP")));
    			
    		}
    	}
    	catch(Exception e) {
    		
    	}
		return list;
    	
    }
    @FXML
	private void ShowSearch(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MP-Search");
		borderpane.setCenter(view);

	}
    @FXML
   
    protected TextArea EducationD;
    @FXML
	public void ResetD(ActionEvent e) {
		F_name.setText("");
		L_name.setText("");
		Email.setText("");
		Password.setText("");
		M_num.setText("");
		EducationD.setText("");
		DOB.setValue(null );
	}
    @FXML
	public void AddDoc(ActionEvent event) {
		 createconnection();
		 
		 String val1 = F_name.getText();
	     String val2 = L_name.getText();
	     String val3 = Email.getText();
	     String val4 = Password.getText();
	     String val5 = M_num.getText();
	     String val6 = EducationD.getText();
	     LocalDate val7 = DOB.getValue();
         if(val1 != null&&val2 != null&&val3 != null&&val4 != null&&val5 != null&&val6 != null&&val7 != null) {
	    	 
	    	 try {

	    		    Statement stm = con.createStatement();

					ResultSet rs = stm.executeQuery("SELECT * FROM newdoctor WHERE F_NameD = '"+val1+"' AND L_NameD = '"+val2+"' AND Email_idD = '"+val3+"' AND PasswordD = '"+val4+"' ");

					if ( rs.next()) {

				         label.setText("Already Added As Doctor");
				         PauseTransition pause = new PauseTransition(Duration.seconds(3));
				    	 pause.setOnFinished(e -> label.setText(null));
				    	 pause.play();						
					}
					else {
						Statement stmt = con.createStatement();
			 			String rs1="INSERT INTO `pharmacydb`.`newdoctor`"+ " (`F_NameD`, `L_NameD`,`Email_idD`, `PasswordD`,`DOBD`, `M_NumberD`, `EducationD`)"
			 			+ "VALUES('" +val1+"','"+val2+"','" +val3+"','"+val4+"','" +val7+"','"+val5+"','"+val6+"' )";
			 			
			 			Statement stmt2 = con.createStatement();
			 			String rs2 = "INSERT INTO `pharmacydb`.`userdata`"+ " (`User_name`, `Password`,`ID`)"+ "VALUES('" +val3+"','"+val4+"','4')";
			 			stmt2.execute(rs2);
			 			stmt.execute(rs1);
			 			stmt.close();
			 			stmt2.close();

				        label.setText("Applied Successfully");
				        PauseTransition pause = new PauseTransition(Duration.seconds(2));
				        pause.setOnFinished(e -> label.setText(null));
				        pause.play();
					}
					stm.close(); 
	 			
	 		} catch (SQLException e) {
	 				
	 			e.printStackTrace();
	 		}
	    	 
	     }
	     else {
	    	 label.setText("Invalid Input Found");
	    	 PauseTransition pause = new PauseTransition(Duration.seconds(2));
	    	 pause.setOnFinished(e -> label.setText(null));
	    	 pause.play();
	     }
   }
    
    @FXML
	protected TextField Drug_id;
	@FXML
	protected TextField Drug_name; 
	@FXML
	protected TextField Category; 
    @FXML
	protected TextField Price;
	@FXML
	protected TextField Company; 
	@FXML
	protected TextField Quantity; 
	@FXML
	protected TextField Manu_Date;
	@FXML
	protected TextField Exp_Date; 
	@FXML
	protected TextArea Description; 
	@FXML
   	public void ResetM(ActionEvent e) {
		Drug_id.setText("");
		Drug_name.setText("");
		Category.setText("");
		Price.setText("");
		Company.setText("");
		Manu_Date.setText("");
		Exp_Date.setText("");
		Description.setText("");
   		DOB.setValue(null );
   	}
	 @FXML
		public void AddMed(ActionEvent event) {
			 createconnection();
			 
			 String val1 = Drug_id.getText();
		     String val2 = Drug_name.getText();
		     String val3 = Category.getText();
		     String val4 = Price.getText();
		     String val5 = Company.getText();
		     String val6 = Quantity.getText();
		     String val7 = Exp_Date.getText();
		     String val8 = Description.getText();
		     String val9 = Manu_Date.getText();
	         if(val1 != null&&val2 != null&&val3 != null&&val4 != null&&val5 != null&&val6 != null&&val7 != null&&val8 != null&&val9 != null) {
		    	 
		    	 try {
		    		    Statement stm = con.createStatement();
						ResultSet rs = stm.executeQuery("SELECT * FROM newdrug WHERE Drug_id = '"+val1+"' AND Drug_name = '"+val2+"' AND Company = '"+val5+"'");
						if ( rs.next()) {

					         label.setText("Already Added This Medicine");
					         PauseTransition pause = new PauseTransition(Duration.seconds(1));
					    	 pause.setOnFinished(e -> label.setText(null));
					    	 pause.play();						
						}
						else {
							Statement stmt = con.createStatement();
				 			String rs1="INSERT INTO `pharmacydb`.`newdrug`"+ " (`Drug_id`, `Drug_name`,`Category`, `Company`,`Quantity`"
				 					+ ", `Price`, `Exp_Date`, `Description`, `Manu_Date`)"
				 			+ "VALUES('" +val1+"','"+val2+"','" +val3+"','"+val5+"','" +val6+"','"+val4+"','"+val7+"','"+val8+"','"+val9+"' )";
				 			stmt.execute(rs1);
				 			stmt.close();

					        label.setText("Applied Successfully");
					        PauseTransition pause = new PauseTransition(Duration.seconds(1));
					        pause.setOnFinished(e -> label.setText(null));
					        pause.play();
						}
						stm.close(); 
		 			
		 		} catch (SQLException e) {
		 				
		 			e.printStackTrace();
		 		}
		    	 
		     }
		     else {
		    	 label.setText("Invalid Input Found");
		    	 PauseTransition pause = new PauseTransition(Duration.seconds(2));
		    	 pause.setOnFinished(e -> label.setText(null));
		    	 pause.play();
		     }
	   }

	 @FXML
		private void ShowAddMed(ActionEvent e) {
			
			FxmlLoader1 object = new FxmlLoader1();
			view = object.getPage("MM-Add");
			borderpane.setCenter(view);
		}
	 
	 @FXML
	 public void Dashboard() throws IOException {

//		 P1.setStyle("-fx-accent :  #074e0c;");
//		 P2.setStyle("-fx-accent :  #660b0b;");
//		 P3.setStyle("-fx-accent :  #84340f;");
//		 P4.setStyle("-fx-accent :  #5b5500;");
//		 P5.setStyle("-fx-accent :  #000000;");
		 
		 Calendar ca = new GregorianCalendar();
		 
		 int day = ca.get(Calendar.DAY_OF_MONTH);
		 int month =ca.get(Calendar.MONTH);
		 int year = ca.get(Calendar.YEAR);
		 
		 int second = ca.get(Calendar.SECOND);
		 int minute = ca.get(Calendar.MINUTE);
		 int hour = ca.get(Calendar.HOUR);
		 
		 Date.setText(day +" : " +month+" : "+year);
		 Time.setText(hour +" : " +minute+" : "+second);
	 }
	 
}