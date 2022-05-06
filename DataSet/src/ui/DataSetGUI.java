package ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DataSet;
import model.Person;

public class DataSetGUI {
	private Stage mainStage;
	
	private DataSet data;
	
	private int typeMethodToSearch;
	
    @FXML
    private TextField tfNumber;
    
    @FXML
    private Label searchTitle;

    @FXML
    private TextField searcher;
    
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
    
    @FXML
    private Label lbBirthDay;

    @FXML
    private Label lbCountry;
    
    @FXML
    private TableView<Person> tvPerson;

    @FXML
    private TableColumn<Person, String> tcPerson;

    
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
            	alert.setAlertType(AlertType.INFORMATION);
    			alert.setTitle("Information");
    			alert.setHeaderText("Successful process");
    			alert.setContentText("The program created "+numPeople+" peole.");
    			alert.showAndWait();
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

		typeMethodToSearch=4;
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

		typeMethodToSearch=3;
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

    	typeMethodToSearch=2;
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

    	typeMethodToSearch=1;
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
    
    public void itializeTableView() {
    	ObservableList<Person> items= FXCollections.observableArrayList(data.getPersons());
    	if(data.getPersons().size()<=100) {
        	tvPerson.setItems(items);
        	tcPerson.setCellValueFactory(new PropertyValueFactory<Person, String>("comparatorValue"));
    	}
    }
    
    
    public void initializeComboBoxPeople() {
    	ObservableList<Person> items = FXCollections.observableArrayList();
    	if(data.getPersons().size()<=100) {
        	items.addAll(data.getPersons());
        	cbListPerson.getItems().addAll(items);
    	}
    	cbListPerson.setOnAction(new EventHandler<ActionEvent>() {     
    		public void handle(ActionEvent e)  {    
    			tempPerson=cbListPerson.getValue();
    		}       
    	});
    }
    
    
    @FXML
    private Label searchTitle1;
    
    
    @FXML
    public void tosearchAndShow1(KeyEvent event) {
    	cbListPerson.getItems().clear();
    	String texto=searcher.getText();
    	if(!texto.isEmpty()) {
	    	data.addPeopletoShow(texto,typeMethodToSearch);
	    	initializeComboBoxPeople();
	    	itializeTableView();
	    	searchTitle1.setText(texto);
    	}
    }

    @FXML
    public void tosearchAndShow2(KeyEvent event) {
    	cbListPerson.getItems().clear();
    	String texto=searcher.getText();
    	if(!texto.isEmpty()) {
	    	data.addPeopletoShow(texto,typeMethodToSearch);
	    	itializeTableView();
	    	initializeComboBoxPeople();
	    	searchTitle1.setText(texto);
    	}
    }
 
    
    @FXML
    public void toViewPerson(ActionEvent event) throws IOException {
    	if(tempPerson==null) {
    		Alert alert=new Alert(null);
    		alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Select a person");
			alert.setContentText("You must choose a person first to view his/her information.");
			alert.showAndWait();
    	}
    	else {
        	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("PersonalInformation.fxml"));
        	fxmlloader.setController(this);
        	Parent root= fxmlloader.load();
        	Scene scene= new Scene (root);
    		mainStage.setScene(scene);
        	mainStage.setTitle("view Page");
        	showInformationPerson(tempPerson);
    		mainStage.show();
    	}
    }
    
    public void showInformationPerson(Person p) {
    	lbName.setText(p.getName());
    	lbLastname.setText(p.getLastName());
    	lbAge.setText(p.getAge()+"");
    	lbHeight.setText(p.getHeight()+"");
    	lbCode.setText(p.getCode());
    	lbBirthDay.setText(p.getDateOfBirth());
    	lbCountry.setText(p.getNacionality());
    	File f = new File(p.getProfilePhoto());
    	Image imagen=new Image(f.toURI().toString());
    	ivPhoto.setImage(imagen);
    }
    

   
    
    @FXML
    public void deletePerson(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation remove");
    	alert.setHeaderText("You are going to delete a person");
    	alert.setContentText("Are you ok with this?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		data.removeFromTrees(tempPerson);
        	toBack(event);
    	}
    	
    }
    
    @FXML
    public void upgradePerson(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("UpdatePage.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("Update Page");
		mainStage.show();
    }
    
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtBirthDate;

    @FXML
    private TextField txtHeight;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtPhoto;
    
    @FXML
    public void searchUrl(ActionEvent event) throws MalformedURLException {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File selectedDirectory = fileChooser.showOpenDialog(mainStage);
    	txtPhoto.setText(selectedDirectory.toURI().toURL().toString());
    }	
    

    @FXML
    public void acceptUpdate(ActionEvent event) {
    	if(tempPerson==null) {
    		Alert alert=new Alert(null);
    		alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Select a person");
			alert.setContentText("You must choose a person first to upgrade his/her information.");
			alert.showAndWait();
    	}
    	else {
    		String newName=txtName.getText();
        	String newLastName=txtLastName.getText();
        	String newBirthday=txtBirthDate.getText();
        	String newHeight=txtHeight.getText();
        	String newCountry=txtCountry.getText();
        	String newPhoto=txtPhoto.getText();
        	if(newName.isEmpty()) {
        		newName=tempPerson.getName();
        	}
        	if(newLastName.isEmpty()) {
        		newLastName=tempPerson.getLastName();
        	}
        	if(newBirthday.isEmpty()) {
        		newBirthday=tempPerson.getDateOfBirth();
        	}
        	if(newHeight.isEmpty()) {
        		newHeight=tempPerson.getHeight()+"";
        	}
        	if(newCountry.isEmpty()) {
        		newCountry=tempPerson.getNacionality();
        	}
        	if(newPhoto.isEmpty()) {
        		newPhoto=tempPerson.getProfilePhoto();
        	}
        	data.editPerson(tempPerson, newName, newLastName, newBirthday, newPhoto, newCountry, newHeight, tempPerson.getCode());
        	
    	}
    	
    }

    @FXML
    public void cancelUpdate(ActionEvent event) {

    }
    
   
}