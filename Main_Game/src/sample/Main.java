package sample;

import javafx.animation.AnimationTimer;
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
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception, FileNotFoundException {
        Parent root1 = FXMLLoader.load(getClass().getResource("lawnLevel3.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("chooseLevel.fxml"));
        primaryStage.setTitle("Test");
        Scene s1 = new Scene(root,600,400);
//        Scene s2 = new Scene(root1,600,400);
        primaryStage.show();
        primaryStage.setScene(s1);
        


//        primaryStage.setScene(s2);
















       ;


    
//





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
