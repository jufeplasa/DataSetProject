package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
	private static DataSetGUI dataGUI;
	
	public static void main(String[] args) throws IOException {
		dataGUI=new DataSetGUI();
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
		fxmlLoader.setController(dataGUI);
		Parent root = fxmlLoader.load();
		dataGUI.setMainStage(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Start Window");
		primaryStage.show();
	}
}