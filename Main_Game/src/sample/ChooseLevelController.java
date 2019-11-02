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

public class ChooseLevelController  {

  @FXML
    private Button button;
  @FXML
    Stage stage;
  @FXML
  Parent lawn1,lawn2,lawn3;
  public ChooseLevelController() throws IOException {

  }
  @FXML
    public void initialize(){

  }

    private void createScene(Parent p,String fxmlfile,ActionEvent event) throws IOException {
        p =  FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene scene = new Scene(p);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
        stage.setScene(scene);
    }
  public void changeScene3(ActionEvent event) throws IOException {
      createScene(lawn3,"lawnLevel3.fxml",event);

  }
    public void changeScene2(ActionEvent event) throws IOException {
        createScene(lawn2,"lawnLevel2.fxml",event);

    }
    public void changeScene1(ActionEvent event) throws IOException {
        createScene(lawn1,"lawnLevel1.fxml",event);

    }
}
