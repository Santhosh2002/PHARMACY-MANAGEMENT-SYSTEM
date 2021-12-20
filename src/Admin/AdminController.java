package Admin;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import Admin.*;
import application.FxmlLoader;
import application.FxmlLoader1;
import application.Pharmacy;
import application.*;

public class AdminController {
	private Stage stage;
	@FXML
	private BorderPane borderpane; 
	@FXML
	private BorderPane borderpane1; 
	
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
	Pane view1;
	@FXML
	private void ShowManageP(ActionEvent e) throws IOException {
		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManagePharmacist1.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManagePharmacist1");
		borderpane.setCenter(view);
		
		view1 = object1.getPage("MP-Add1");
		((BorderPane) borderpane1).setCenter(view1);
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
		view = object.getPage("MP-Add1");
		borderpane1.setCenter(view);
	}
	@FXML
	private void ShowSearch(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MP-Search");
		borderpane1.setCenter(view);
		addButtonToTable();
	}
	@FXML
    public void ShowHome(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Pharmacy.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("C:\\Users\\santhosh\\eclipse-workspace\\Pharmacy_Project\\src\\Images\\logo.png");
		
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Home");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	@FXML
    public void Exit (ActionEvent e) {
		stage.close();
	}
	@FXML
	private TableView<Data> PharmacistTable = new TableView <>();
	@FXML
	private void addButtonToTable() {
        TableColumn<Data, Void> edit = new TableColumn<Data, Void>("EDIT");

        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
            @Override
            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

                    private final Button btn = new Button("EDIT");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Data data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        edit.setCellFactory(cellFactory);

        PharmacistTable.getColumns().add(edit);

    }
}
