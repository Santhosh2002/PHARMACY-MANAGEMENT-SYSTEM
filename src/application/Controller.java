package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import Admin.*;
import Doctor.*;
import Pharmacist.*;
import User.*;
import javafx.scene.*;

public class Controller extends Pharmacy{
	
	private Stage stage;
	@FXML
	public BorderPane borderpane; 
	@FXML
	public BorderPane borderpane1; 
	@FXML
	private Label label1;
	@FXML
	private TextField F_name1;
	@FXML
	private TextField L_name1; 
	@FXML
	private TextField Email1; 
	@FXML
	private PasswordField NPassword;
	@FXML
	private PasswordField CPassword; 
	@FXML
	private Label label2;
	Connection con;
	
    void createconnection() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PHARMACYDB","root","$@i&@nt#O$hMy1");
			System.out.println("Connected");
			
		} catch (ClassNotFoundException | SQLException ex) {
			
			Logger.getLogger(Pharmacy.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	Pane view;
	
	@FXML
	private void ShowSignin(ActionEvent e) {
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Signin");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowSignup(ActionEvent e) {
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Signup");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowHome(ActionEvent e) {
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Home");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowApply(ActionEvent e) {
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Apply");
		borderpane.setCenter(view);
	}
	@FXML
	private TextField F_name;
	@FXML
	private TextField L_name; 
	@FXML
	private TextField Email; 
	@FXML
	private PasswordField Password2; 
	@FXML
	private TextField M_num;
	@FXML
	private TextArea Address; 
	@FXML
	private DatePicker DOB;
	@FXML
	private void Reset(ActionEvent e) {
		F_name.setText("");
		L_name.setText("");
		Email.setText("");
		Password2.setText("");
		M_num.setText("");
		Address.setText("");
		DOB.setValue(null );
	}
	@FXML
	private Label label;
	@FXML
	private void Signup(ActionEvent event) {
		 createconnection();
		 
		 String val1 = F_name.getText();
	     String val2 = L_name.getText();
	     String val3 = Email.getText();
	     String val4 = Password2.getText();
	     String val5 = M_num.getText();
	     String val6 = Address.getText();
	     LocalDate val7 = DOB.getValue();
	     if(val1 != null&&val2 != null&&val3 != null&&val4 != null&&val5 != null&&val6 != null&&val7 != null) {
	    	 
	    	 try {
	    		 Statement stm = con.createStatement();

					ResultSet rs = stm.executeQuery("SELECT * FROM newuserd WHERE F_Name = '"+val1+"' AND L_Name = '"+val2+"' AND Email_id = '"+val3+"' AND Password = '"+val4+"' ");

					if ( rs.next()) {
						 label.setText("Already Registered");
				         PauseTransition pause = new PauseTransition(Duration.seconds(2));
				    	 pause.setOnFinished(e -> label.setText(null));
				    	 pause.play();
					}
					
					else{
						Statement stmt = con.createStatement();
			 			String rs2="INSERT INTO `pharmacydb`.`newuserd`"+ " (`F_Name`, `L_Name`,`Email_id`, `Password`,`DOB`, `M_Number`, `Address`)"
			 			+ "VALUES('" +val1+"','"+val2+"','" +val3+"','"+val4+"','" +val7+"','"+val5+"','"+val6+"' )";
			 			
			 			Statement stmt1 = con.createStatement();
			 			String rs1 = "INSERT INTO `pharmacydb`.`userdata`"+ " (`User_name`, `Password`,`ID`)"+ "VALUES('" +val3+"','"+val4+"','3')";
			 			stmt1.execute(rs1);
			 			stmt.execute(rs2);
			 			stmt.close();
			 			stmt1.close();
			 			
			 			label.setText("Signup Successfull");
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
    public void ShowAdmin(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/Admin.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add(getClass().getResource("/Admin/application.css").toExternalForm());
		Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
		
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("Dashboard");
		((BorderPane) borderpane1).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
public void ShowDoctor(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Doctor/User.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/Admin/application.css").toExternalForm());
		Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
		
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Dashboard");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
    public void ShowPharmacist(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pharmacist/Pharmacist.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/Admin/application.css").toExternalForm());
		Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
		
		
		FxmlLoader3 object = new FxmlLoader3();
		view = object.getPage("Dashboard");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
    public void ShowUser(ActionEvent e) throws IOException {
	
	Parent borderpane1 ;
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/User/User.fxml"));
	borderpane1 = loader.load();
	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	Scene scene = new Scene(borderpane1);
//	scene.getStylesheets().add(getClass().getResource("/Admin/application.css").toExternalForm());
	Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
	
	FxmlLoader2 object = new FxmlLoader2();
	view = object.getPage("Dashboard");
	((BorderPane) borderpane1).setCenter(view);
	
	stage.getIcons().add(icon);
	stage.setScene(scene);
	stage.show();
	stage.setResizable(false);
}
	@FXML
	private TextField F_nameP;
	@FXML
	private TextField L_nameP; 
	@FXML
	private TextField EmailP; 
	@FXML
	private PasswordField Password2P; 
	@FXML
	private TextField M_numP;
	@FXML
	private TextArea QualificationP; 
	@FXML
	private DatePicker DOBP;
	
	@FXML
	private void Apply(ActionEvent event) {
		 createconnection();
		 
		 String val1 = F_nameP.getText();
	     String val2 = L_nameP.getText();
	     String val3 = EmailP.getText();
	     String val4 = Password2P.getText();
	     String val5 = M_numP.getText();
	     String val6 = QualificationP.getText();
	     LocalDate val7 = DOBP.getValue();
         if(val1 != null&&val2 != null&&val3 != null&&val4 != null&&val5 != null&&val6 != null&&val7 != null) {
	    	 
	    	 try {

	    		    Statement stm = con.createStatement();

					ResultSet rs = stm.executeQuery("SELECT * FROM newpharmacistd WHERE F_NameP = '"+val1+"' AND L_NameP = '"+val2+"' AND Email_idP = '"+val3+"' ");

					if ( rs.next()) {

				         label.setText("Already Applied for Pharmacist");
				         PauseTransition pause = new PauseTransition(Duration.seconds(3));
				    	 pause.setOnFinished(e -> label.setText(null));
				    	 pause.play();						
					}
					else {
						Statement stmt = con.createStatement();
			 			String rs1="INSERT INTO `pharmacydb`.`newpharmacistd`"+ " (`F_NameP`, `L_NameP`,`Email_idP`, `PasswordP`,`DOBP`, `M_NumberP`, `QualificationP`)"
			 			+ "VALUES('" +val1+"','"+val2+"','" +val3+"','"+val4+"','" +val7+"','"+val5+"','"+val6+"' )";
			 			
			 			Statement stmt2 = con.createStatement();
			 			String rs2 = "INSERT INTO `pharmacydb`.`userdata`"+ " (`User_name`, `Password`,`ID`)"+ "VALUES('" +val3+"','"+val4+"','2')";
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
	private void Reset2(ActionEvent e) {
		F_nameP.setText("");
		L_nameP.setText("");
		EmailP.setText("");
		Password2P.setText("");
		M_numP.setText("");
		QualificationP.setText("");
		DOBP.setValue(null );
	}
	@FXML
	private void Chat(MouseEvent e) {
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("chat1");
		borderpane1.setRight(view);

	}
	@FXML
	private TextField Userid;
	@FXML
	private PasswordField Password1;
	@FXML
	private void Signin(ActionEvent event) throws IOException {
		
		createconnection();
		
		String Var1 = Userid.getText();
		String Var2 = Password1.getText();
		
		if (Var1 != null&&Var2 != null) {
			int User_id = 0;
			try {
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT ID FROM userdata WHERE User_name = '"+Var1+"' AND Password = '"+Var2+"' ");

				while ( rs.next()) {
					User_id =  rs.getInt(1);	
				}
				stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(User_id == 1 ) {
				
				label1.setText("Signin Successfull");
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
		    	pause.setOnFinished(e -> label1.setText(null));
		    	pause.play();
		    	ShowAdmin(event);
			}
			else if(User_id == 2) {
				
				label1.setText("Signin Successfull");
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
		    	pause.setOnFinished(e -> label1.setText(null));
		    	pause.play();
		    	ShowPharmacist(event);

			}
            else if(User_id == 3) {
				
				label1.setText("Signin Successfull");
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
		    	pause.setOnFinished(e -> label1.setText(null));
		    	pause.play();
		    	ShowUser(event);

			}
            else if(User_id == 4) {
				
				label1.setText("Signin Successfull");
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
		    	pause.setOnFinished(e -> label1.setText(null));
		    	pause.play();
		    	ShowDoctor(event);

			}
			else {
				
				label1.setText("Invalid UserId or Passward");
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
		    	pause.setOnFinished(e -> label1.setText(null));
		    	pause.play();
			}
		}
		else {
			label1.setText("Invalid UserId or Passward");
			PauseTransition pause = new PauseTransition(Duration.seconds(3));
	    	pause.setOnFinished(e -> label1.setText(null));
	    	pause.play();
		}
        
	}
	
	@FXML
	private void ForgotPassword(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Password.fxml"));
			loader.load();
			Parent root = loader.getRoot();
			Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
			Stage stage = new Stage();
			stage.getIcons().add(icon);
			stage.setTitle("Forgot Password");
			stage.setScene(new Scene(root));
			stage.show();
			stage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Next(ActionEvent event) {
		 createconnection();
		 String val1 = F_name1.getText();
	     String val2 = L_name1.getText();
	     String val3 = Email1.getText();
	     String val4 = NPassword.getText();
	     String val5 = CPassword.getText();
	     
	     int User_id = 0 ;
	     if(val4.equals(val5)) {
	    	 try {
	 			Statement stmt = con.createStatement();

	 			ResultSet rs = stmt.executeQuery("SELECT Id FROM newuserd WHERE F_Name = '"+val1+"' AND L_Name = '"+val2+"' AND Email_ld = '"+val3+"'");
	 			
	 			while ( rs.next()) {
	 				User_id =  rs.getInt(1);
	 				
    			}
	 				
	 			stmt.close();
	 		} catch (SQLException e) {
	 			
	 			e.printStackTrace();
	 		}
	    	 
	    	 if(User_id != 0) {
	    		 try {
	 	 			Statement stmt = con.createStatement();
	 	 			Statement stmt1 = con.createStatement();
	 	 			String rs = "UPDATE newuserd SET Password ='" +val5+"' WHERE Email_ld = '"+val3+"' AND F_Name = '"+val1+"' AND L_Name = '"+val2+"' ";
	 	 			
	 	 			String rs1 = "UPDATE userdata SET Password ='" +val5+"' WHERE User_name = '"+val3+"'";
	 	 			
	 	 			stmt.execute(rs);
	 	 			stmt1.execute(rs1);
	 	 			label2.setText("Password Changed Successfully");
	 				PauseTransition pause = new PauseTransition(Duration.seconds(5));
	 			    pause.setOnFinished(e -> label2.setText(null));
	 			    pause.play();
	 	 			stmt.close();
	 	 		} catch (SQLException e) {
	 	 			
	 	 			e.printStackTrace();
	 	 		}
	    	 }
	    	 else {
	    		 label2.setText("Email id not found");
					PauseTransition pause = new PauseTransition(Duration.seconds(5));
			    	pause.setOnFinished(e -> label2.setText(null));
			    	pause.play();
	    	 }
	    	 
	     }
	     else {
	    	 label2.setText("Password Mismatched");
				PauseTransition pause = new PauseTransition(Duration.seconds(5));
		    	pause.setOnFinished(e -> label2.setText(null));
		    	pause.play();
	     }
	}

}

