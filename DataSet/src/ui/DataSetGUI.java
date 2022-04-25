package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Person;

public class DataSetGUI {
	private Stage mainStage;
	
    @FXML
    private TextField tfNumber;
    
    @FXML
    private Label searchTitle;

    @FXML
    private TextField searcher;
    
    @FXML
    private TableView<Person> PersonTable;
    
    @FXML
    private TableColumn<Person, String> tcPerson;
    
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
    	mainStage.setTitle("Create Page");
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
    	mainStage.setTitle("Star Page");
		mainStage.show();
    }
    @FXML
    public void tosearchByCode(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("searchPage.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("Search Page");
    	String prev=searchTitle.getText();
    	searchTitle.setText(prev+"code");
		mainStage.show();
    }

    @FXML
    public void tosearchByFullname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("searchPage.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("Search Page");
    	String prev=searchTitle.getText();
    	searchTitle.setText(prev+"fullname");
		mainStage.show();
    }

    @FXML
    public void tosearchByLastname(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("searchPage.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("Search Page");
    	String prev=searchTitle.getText();
    	searchTitle.setText(prev+"lastname");
		mainStage.show();
    }

    @FXML
    public void tosearchByName(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("searchPage.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("Search Page");
    	String prev=searchTitle.getText();
    	searchTitle.setText(prev+"name");
		mainStage.show();
    }
    
    public void initializeTableViewEmployees() {
		ObservableList<Person> observableList;
		/*observableList= FXCollections.observableArrayList(null);
		PersonTable.setItems(observableList);
		tcPerson.setCellFactory(new PropertyValueFactory<Person,String>("Name"));*/
    }

    @FXML
    public void tosearchAndShow(KeyEvent event) {
    	initializeTableViewEmployees();
    }

}