package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Lawn1Controller implements Initializable {

    @FXML
    private ImageView zombie1;
    @FXML
    private ImageView peashooter_card, onexzero, twoxzero, threexzero, fourxzero, fivexzero, sixxzero, sevenxzero, eightxzero, ninexzero;

    @FXML
    public void handleDragDetected(MouseEvent event) throws FileNotFoundException{
        Dragboard db = peashooter_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\peashooter.gif");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();
    }
    // for lawn
    @FXML
    public void handleDragOver(DragEvent event){
        if(event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    //for lawn
    @FXML
    public void handleDragDrop(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexzero.setImage(peashooter_img);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zombiemove();
    }
    public void zombiemove() {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(30), zombie1);
        tt.setFromX(zombie1.getX() );
        tt.setToX( zombie1.getX()-400 );
        tt.setCycleCount(1);
        tt.play();
        // to make the the image invisible
        tt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                zombie1.setVisible(false);
            }
        });

    }



}
