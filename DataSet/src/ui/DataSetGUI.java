package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DataSet;
import model.Person;

public class DataSetGUI {
	private Stage mainStage;
	
	private DataSet data;
	
    @FXML
    private TextField tfNumber;
    
    @FXML
    private Label searchTitle;

    @FXML
    private TextField searcher;
    
    @FXML
    private Label lbSelectPerson;
    
    @FXML
    private ImageView ivPhoto;

    @FXML
    private Label lbName;

    @FXML
    private Label lbLastname;

    @FXML
    private Label lbAge;

    @FXML
    private Label lbHeight;

    @FXML
    private Label lbCode;

    
    public DataSetGUI() {
    }
    
	public void setMainStage(Stage primaryStage) throws IOException {
		mainStage=primaryStage;
		data=new DataSet();
    	ivPhoto=new ImageView();
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
            	for(int i=0;i<numPeople;i++) {
            		data.addPerson();
            	}
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
    	initializeComboBoxPeople(); 
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
    	initializeComboBoxPeople(); 
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
    	initializeComboBoxPeople(); 
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
    	initializeComboBoxPeople(); 
    }
    
    
    @FXML
    private ComboBox<Person> cbListPerson;
    
    private Person tempPerson;
    
    
    public void initializeComboBoxPeople() {
    	ObservableList<Person> items = FXCollections.observableArrayList();
    	
    	items.addAll(data.getPersons());
    	cbListPerson.getItems().addAll(items);
    	cbListPerson.setOnAction(new EventHandler<ActionEvent>() {     
    		public void handle(ActionEvent e)  {    
    			tempPerson=cbListPerson.getValue();
    		}       
    	});
    }
    
    @FXML
    private Label searchTitle1;
    
    @FXML
    public void tosearchAndShow(KeyEvent event) {
    	String texto=searcher.getText();
    	searchTitle1.setText(texto);
    }
 
    
    @FXML
    public void toViewPerson(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("PersonalInformation.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("view Page");
    	showInformationPerson(tempPerson);
		mainStage.show();
    }
    
    public void showInformationPerson(Person p) {
    	lbName.setText(p.getName());
    	lbLastname.setText(p.getLastName());
    	lbAge.setText(p.getAge()+"");
    	lbHeight.setText(p.getHeight()+"");
    	lbCode.setText("UPS");
    	File f = new File(p.getProfilePhoto());
    	Image imagen=new Image(f.toURI().toString());
    	ivPhoto.setImage(imagen);
    }
    
    @FXML
    public void deletePerson(ActionEvent event) {

    }
    
    @FXML
    public void upgradePerson(ActionEvent event) {

    }
}