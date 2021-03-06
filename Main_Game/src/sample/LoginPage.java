package  sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

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



public class LoginPage {
    public Game pvz;
    public String username="";
    @FXML
    private TextField textarea;

    @FXML
    private Button btn;

    @FXML
    Parent mainpage;

// connect with fxml and add text field to get username and update the field username
    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    Stage stage;

    private void createScene(Parent p,String fxmlfile,ActionEvent event) throws IOException {
        p =  FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene scene = new Scene(p);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
        stage.setScene(scene);
    }

    public String getUsername() {
        return username;
    }
    @FXML
    public void text_entered(ActionEvent event) throws IOException {
        String user = textarea.getText();
        setUsername(user);
        System.out.println(username);
        pvz = new Game(getUsername());
        createScene(mainpage,"mainpage.fxml",event);
//        pvz.serialze();
//        System.out.println("test");


    }

    @FXML
    public void onSerialize(ActionEvent event) throws IOException {
//        System.out.println(pvz.current_Player.getUsername());
//        pvz.serialze();
    }

    @FXML
    public void onDeserialize(ActionEvent event) throws IOException, ClassNotFoundException {
        pvz = Game.deserialize();
    }

    }

