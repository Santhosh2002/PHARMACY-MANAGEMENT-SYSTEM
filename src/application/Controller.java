package application;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.util.Duration;


public class Controller {
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
	public BorderPane borderpane; 
	
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
		view = object.getPage("Home1");
		borderpane.setCenter(view);
	}
	@FXML
	private TextField F_name;
	@FXML
	private TextField L_name; 
	@FXML
	private TextField Email; 
	@FXML
	private TextField Passward; 
	@FXML
	private TextField M_num;
	@FXML
	private TextArea Address; 
	@FXML
	private DatePicker DOB;
	@FXML
	private Label label;
	
	@FXML
	private void Reset(ActionEvent e) {
		F_name.setText("");
		L_name.setText("");
		Email.setText("");
		Passward.setText("");
		M_num.setText("");
		Address.setText("");
		DOB.setValue(null );
	}
	@FXML
	private void Signup(ActionEvent event) {
		 createconnection();
		 String val1 = F_name.getText();
	     String val2 = L_name.getText();
	     String val3 = Email.getText();
	     String val4 = Passward.getText();
	     String val5 = M_num.getText();
	     String val6 = Address.getText();
	     LocalDate val7 = DOB.getValue();
	     if(val1 != null&&val2 != null&&val3 != null&&val4 != null&&val5 != null&&val6 != null&&val7 != null) {
	    	 
	    	 try {
	 			Statement stmt = con.createStatement();
	 			String rs="INSERT INTO `pharmacydb`.`newuserd`"+ " (`F_Name`, `L_Name`,`Email_ld`, `Password`,`DOB`, `M_Number`, `Address`)"
	 			+ "VALUES('" +val1+"','"+val2+"','" +val3+"','"+val4+"','" +val7+"','"+val5+"','"+val6+"' )";
	 			
	 			Statement stmt1 = con.createStatement();
	 			String rs1 = "INSERT INTO `pharmacydb`.`userdata`"+ " (`User_name`, `Password`)"+ "VALUES('" +val3+"','"+val4+"')";
	 			stmt1.execute(rs1);
	 			stmt.execute(rs);
	 			stmt.close();
	 			stmt1.close();
	 		} catch (SQLException e) {
	 				
	 			e.printStackTrace();
	 		}
	    	 
	         label.setText("Signup Successfull");
	         PauseTransition pause = new PauseTransition(Duration.seconds(2));
	    	 pause.setOnFinished(e -> label.setText(null));
	    	 pause.play();
	    	 
	     }
	     else {
	    	 label.setText("Invalid Input Found");
	    	 PauseTransition pause = new PauseTransition(Duration.seconds(2));
	    	 pause.setOnFinished(e -> label.setText(null));
	    	 pause.play();
	    	 
	     }
	     
        
	}
	@FXML
	public BorderPane borderpane1; 
	@FXML
	private void Chat(MouseEvent e) {
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("chat1");
		borderpane1.setRight(view);

	}
	@FXML
	private TextField Userid;
	@FXML
	private TextField Passward1;
	@FXML
	private Label label1;
	@FXML
	private void Signin(ActionEvent event) {
		createconnection();
		String Var1 = Userid.getText();
		String Var2 = Passward1.getText();
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT USERID FROM userdata WHERE User_name = '"+Var1+"' AND Password = '"+Var2+"' ");

			int User_id = 0;
			
			while ( rs.next()) {
				User_id =  rs.getInt(1);
				
			}
			if(User_id == 1 || User_id == 2 ) {
				
				label1.setText("Signin Successfull");
				
				PauseTransition pause = new PauseTransition(Duration.seconds(2));
		    	pause.setOnFinished(e -> label.setText(null));
		    	pause.play();
			}
			else {
				label1.setText("Invalid UserId or Passward");
				PauseTransition pause = new PauseTransition(Duration.seconds(2));
		    	pause.setOnFinished(e -> label.setText(null));
		    	pause.play();
			}

			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
	}

}

