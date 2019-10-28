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
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);


        // Loading Page Scene 1
        primaryStage.setTitle("Loading Page");
        Button button = new Button("Login Page");
        button.setOnAction(new ClickEvent());

        String loading_Page_String = currentDirectory+ "\\pvz_images\\loadingpage.png";
        Image loading_Page_Image = new Image(new FileInputStream(loading_Page_String));
        ImageView loading_Page_Image_View = new ImageView(loading_Page_Image);
        loading_Page_Image_View.fitWidthProperty().bind(primaryStage.widthProperty());

        BorderPane root = new BorderPane();
        root.setBottom(button);
        root.setCenter(loading_Page_Image_View);
        Scene scene = new Scene(root,1000,250);
        primaryStage.setScene(scene);
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
