package pl.stanikov.mp3playerv2.controller;
 
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
 
public class MenuPaneController implements Initializable {
	
	@FXML
    private MediaView mediaVieww;
 
    @FXML
    private MenuItem aboutMenuItem;
 
    @FXML
    private MenuItem fileMenuItem;
 
    @FXML
    private MenuItem closeMenuItem;
 
    @FXML
    private MenuItem dirMenuItem;
 
    @FXML
    private Menu fileMenu;
 
    public MenuItem getFileMenuItem() {
        return fileMenuItem;
    }
 
    public MenuItem getDirMenuItem() {
        return dirMenuItem;
    }
 
    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }
 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        configureMenu();
    }
 
    private void configureMenu() {
        closeMenuItem.setOnAction(x -> Platform.exit());
 
        /*aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/pl/stanikov/mp3playerv2/view/AboutPane.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("VideoPlayer");
                stage.setScene(scene);
                stage.show();
            }
        });*/
        MenuItem openFileV = aboutMenuItem;
        
        openFileV.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                fc.getExtensionFilters().add(new ExtensionFilter("Mp4", "*.mp4"));
                File file = fc.showOpenDialog(new Stage());
                Media media = new Media(file.toURI().toString());
                MediaPlayer player = new MediaPlayer(media);
                //player.setAutoPlay(true);
                //mediaView.setMediaPlayer(player);
                
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/pl/stanikov/mp3playerv2/view/VideoPane.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("VideoPlayer");
                stage.setScene(scene);
                stage.show();
                player.setAutoPlay(true);
                mediaVieww.setMediaPlayer(player);
            }
        });
    }
}