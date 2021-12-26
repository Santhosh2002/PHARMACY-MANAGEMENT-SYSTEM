package Stocks;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader1 {
	
	private Pane view ;
	
	public Pane getPage(String fileName) {
		
		try {
			URL fileUrl = StocksController.class.getResource("/Admin/"+ fileName +".fxml");
			
			if(fileUrl == null) {
				throw new java.io.FileNotFoundException("FXML file Can't be found");
				}
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

}
