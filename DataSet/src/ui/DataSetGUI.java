package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DataSetGUI {
	private Stage mainStage;
	
    @FXML
    private TextField tfNumber;
    
    public DataSetGUI() {
    }
    
	public void setMainStage(Stage primaryStage) {
		mainStage=primaryStage;
	}
	

    @FXML
    public void save(ActionEvent event) {

    }

    @FXML
    public void toWindowCreate(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("Create.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("window2");
		mainStage.show();
    }
    

    @FXML
    public void createPeople(ActionEvent event) {
    	String strNumPeople=tfNumber.getText();

    	Alert alert=new Alert(null);
    	if(strNumPeople.isEmpty()) {
    		alert.setAlertType(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Please enter an Integer");
			alert.setContentText("Enter a number to create people.");
			alert.showAndWait();
    	}
    	else if(strNumPeople.contains(",")||strNumPeople.contains(".")) {
    		alert.setAlertType(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Please enter an Integer");
			alert.setContentText("Dont enter decimal numbers.");
			alert.showAndWait();
    	}
    	else {
    		int numPeople=Integer.parseInt(strNumPeople);
    		if(numPeople<=0) {
    			alert.setAlertType(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText("Please enter postive number");
    			alert.setContentText("Enter a number higher than 0");
    			alert.showAndWait();
        	}
        	else {
            	//action
        	}
    	}
    }
    
    @FXML
    public void toBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("Inicio.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("StarPage");
		mainStage.show();
    }

}