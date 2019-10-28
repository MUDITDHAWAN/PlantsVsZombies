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
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("new hello world");
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String peashooter = currentDirectory+ "\\pvz_images\\plant_gifs\\peashooter.gif";
        Image image = new Image(new FileInputStream(peashooter));
        ImageView iv = new ImageView(image);
        iv.setX(350);
        iv.setY(0);
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        iv.setPreserveRatio(true);

        String main_video = currentDirectory + "\\pvz_images\\loading_video.mp4";
        Media main_menu = new Media(currentDirectory + "\\pvz_images\\loading_video.mp4");
        MediaPlayer play_video = new MediaPlayer(main_menu);
        play_video.setAutoPlay(true);
        

        Button button = new Button("click me now");

        button.setOnAction(new ClickEvent());
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        Group root = new Group(stackPane,iv);
        Scene scene = new Scene(root,1000,250);
        primaryStage.setScene(scene);
        primaryStage.show();
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
