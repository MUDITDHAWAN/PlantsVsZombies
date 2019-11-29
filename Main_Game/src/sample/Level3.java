package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
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

public class Level3 extends Level implements Initializable {

    public Level3 (){
        int number_of_Zombies= 5;

        for(int i=0; i< number_of_Zombies; i++){
            arrayList_Zombie.add( new Zombie());
        }
        number_Tracks= 5;

        level_Number =3;

        for(int j=0 ; j<number_Tracks; j++){
            array_Lawnmower.add(new LawnMower());
        }

        plants_Available.add( new ProjectileShooter());
        plants_Available.add( new SunPlant());
        plants_Available.add( new BarrierPlant());
        plants_Available.add( new BombPlant());

    }

    @FXML
    private ImageView peashooter_card,sunflower_card,walnut_card, cherrybomb_card, onexzero, twoxzero, threexzero, onexone, twoxone, threexone, onextwo, twoxtwo, threextwo, onexthree, twoxthree, threexthree, onexfour, twoxfour, threexfour ;

    @FXML
    public void handleDragDetectedPeashooter(MouseEvent event) throws FileNotFoundException{
        Dragboard db = peashooter_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\peashooter.gif");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void handleDragDetectedSunflower(MouseEvent event) throws FileNotFoundException{
        Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\sunflower.gif");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handleDragDetectedWalnut(MouseEvent event) throws FileNotFoundException{
        Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\Wallnut_body.png");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();
    }
    @FXML
    public void handleDragDetectedCherrybomb(MouseEvent event) throws FileNotFoundException{
        Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\cherrybomb.png");
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
    public void handleDragDrop10(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexzero.setImage(peashooter_img);
        plantAttack(onexzero);
    }
    @FXML
    public void handleDragDrop20(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxzero.setImage(peashooter_img);
        plantAttack(twoxzero);
    }
    @FXML
    public void handleDragDrop30(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexzero.setImage(peashooter_img);
        plantAttack(threexzero);
    }

    @FXML
    public void handleDragDrop11(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexone.setImage(peashooter_img);
        plantAttack(onexone);
    }
    @FXML
    public void handleDragDrop21(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxone.setImage(peashooter_img);
        plantAttack(twoxone);
    }
    @FXML
    public void handleDragDrop31(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexone.setImage(peashooter_img);
        plantAttack(threexone);
    }

    @FXML
    public void handleDragDrop12(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onextwo.setImage(peashooter_img);
        plantAttack(onextwo);
    }
    @FXML
    public void handleDragDrop22(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxtwo.setImage(peashooter_img);
        plantAttack(twoxtwo);
    }
    @FXML
    public void handleDragDrop32(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threextwo.setImage(peashooter_img);
        plantAttack(threextwo);
    }

    @FXML
    public void handleDragDrop13(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexthree.setImage(peashooter_img);
        plantAttack(onexthree);
    }
    @FXML
    public void handleDragDrop23(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxthree.setImage(peashooter_img);
        plantAttack(twoxthree);
    }
    @FXML
    public void handleDragDrop33(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexthree.setImage(peashooter_img);
        plantAttack(threexthree);
    }

    @FXML
    public void handleDragDrop14(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexfour.setImage(peashooter_img);
        plantAttack(onexfour);
    }
    @FXML
    public void handleDragDrop24(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxfour.setImage(peashooter_img);
        plantAttack(twoxfour);
    }
    @FXML
    public void handleDragDrop34(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexfour.setImage(peashooter_img);
        plantAttack(threexfour);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zombiemove();
    }

    public void zombiemove() {
//         TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), zombie1);
//         translationElement.setFromX(zombie1.getX() );
//         translationElement.setToX( zombie1.getX()-400 );
//         translationElement.setCycleCount(1);
//         translationElement.play();
//         // to make the the image invisible
//         translationElement.setOnFinished(new EventHandler<ActionEvent>() {
//             @Override
//             public void handle(ActionEvent event) {
//                 zombie1.setVisible(false);
//             }
//         });

//        Timeline timeline = new Timeline();
//        KeyValue keyvalue = new KeyValue(zombie1.translateXProperty(),-400);
//        KeyFrame keyframe = new KeyFrame(Duration.seconds(30),keyvalue);
//        timeline.getKeyFrames().add(keyframe);
//        timeline.play();

    }
        public void plantAttack(ImageView placeHolderPlant) throws FileNotFoundException{
//        double posX= placeHolderPlant.getLayoutX()+placeHolderPlant.getFitWidth();
//        double posY = placeHolderPlant.getLayoutY();
//        System.out.println(posX);
//        System.out.println(posY);
//        String number = placeHolderPlant.getId();
//        double amount = 0;
//        ImageView peaOfPlacedPlant = null;
//        if(number.substring(0,2).equals("on")){
//            peaOfPlacedPlant = peaOfPlacedPlant1;
//
//        }
//        else if(number.substring(0,2).equals("tw")){
//            peaOfPlacedPlant = peaOfPlacedPlant2;
//            amount =45;
//        }
//        else if(number.substring(0,2).equals("th")) {
//            peaOfPlacedPlant = peaOfPlacedPlant3;
//            amount = 90;
//        }
//        else if(number.substring(0,2).equals("fo")){
//            peaOfPlacedPlant = peaOfPlacedPlant4;
//            amount = 180;
//        }
//        else if(number.substring(0,2).equals("fi")){
//            peaOfPlacedPlant = peaOfPlacedPlant5;
//            amount = 225;
//        }
//        else if(number.substring(0,2).equals("si")){
//            peaOfPlacedPlant = peaOfPlacedPlant6;
//            amount = 270;
//        }
//        else if(number.substring(0,2).equals("se")){
//            peaOfPlacedPlant = peaOfPlacedPlant7;
//            amount = 315;
//        }else if(number.substring(0,2).equals("ei")){
//            peaOfPlacedPlant = peaOfPlacedPlant8;
//            amount = 360;
//        }
//        else if(number.substring(0,2).equals("ni")){
//            peaOfPlacedPlant = peaOfPlacedPlant9;
//            amount = 380;
//        }
//
//
//
//        peaOfPlacedPlant.setLayoutX(posX);
//        peaOfPlacedPlant.setLayoutY(posY);
//
//        peaOfPlacedPlant.setVisible(true);
//        System.out.println("pea");
//        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(10-(amount/100)*2), peaOfPlacedPlant);
//        translationElement.setFromX(peaOfPlacedPlant.getX() );
//        translationElement.setCycleCount(TranslateTransition.INDEFINITE);
//        translationElement.setAutoReverse(false);
//        translationElement.setToX( peaOfPlacedPlant.getX()+400- amount );
//
//        translationElement.play();
//
//
    }


    public void checkCollision(ImageView a,ImageView b){
        System.out.println(a.getLayoutBounds().intersects(b.getLayoutBounds()));
        System.out.println(a.getLayoutBounds()+" layoutBound a x");
        System.out.println(b.getLayoutBounds());

    }
}

