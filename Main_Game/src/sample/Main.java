package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception, FileNotFoundException {
        Parent root = FXMLLoader.load(getClass().getResource("loadingPage.fxml"));
        primaryStage.setTitle("Test");

        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();


        // Login page and selecting Day





    }

    public void f2(){
        System.out.println("ohno");
    }
    public void f1(){
        System.out.println("kya yeh chal gaya?");
    }



    public static void main(String[] args) {
        launch(args);
    }
}
class ClickEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("it works!!!");
    }
}
