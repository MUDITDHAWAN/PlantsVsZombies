package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPageController {
    @FXML
    private Button startgame,loadgame,quit,chooselevel;
    @FXML
    Parent lawnScreen,chooseLevelScreen;
    @FXML
    public void initialize(){

    }
    @FXML
    Stage stage;

    public MainPageController(){

    }
    private void createScene(Parent p,String fxmlfile,ActionEvent event) throws IOException {
        p =  FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene scene = new Scene(p);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
        stage.setScene(scene);
    }

    public void startGameButtonPressed(ActionEvent event) throws IOException {
        createScene(lawnScreen,"lawnLevel3.fxml",event);
    }

    public void chooseLevelButtonPressed(ActionEvent event) throws IOException {
        createScene(chooseLevelScreen,"chooseLevel.fxml",event);
    }

    public void quitButtonPressed(ActionEvent event){
        System.exit(0);
    }

}
