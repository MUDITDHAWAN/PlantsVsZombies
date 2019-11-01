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
  public ChooseLevelController() throws IOException {

  }
  @FXML
    public void initialize(){

  }
  public void changeScene3(ActionEvent event) throws IOException {
      Parent levelParent = FXMLLoader.load(getClass().getResource("lawnLevel3.fxml"));
      Scene changed = new Scene(levelParent);
      stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
      stage.setScene(changed);
      stage.show();
  }
}
