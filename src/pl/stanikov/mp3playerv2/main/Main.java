package pl.stanikov.mp3playerv2.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/mp3playerv2/view/MainPane.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setTitle("MP3Player Stanikov");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
