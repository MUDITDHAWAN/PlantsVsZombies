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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
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
            arrayList_Zombie.add( new Zombie("trying"));
        }
        number_Tracks= 5;

        level_Number =3;

        for(int j=0 ; j<number_Tracks; j++){
            array_Lawnmower.add(new LawnMower("trying"));
        }

        plants_Available.add( new ProjectileShooter("trying"));
        plants_Available.add( new SunPlant("trying"));
        plants_Available.add( new BarrierPlant("trying"));
        plants_Available.add( new BombPlant("trying"));

    }

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label number_suns;
    @FXML
    private ImageView suntoken, peashooter_card,sunflower_card,walnut_card, cherrybomb_card, onexzero, twoxzero, threexzero, onexone, twoxone, threexone, onextwo, twoxtwo, threextwo, onexthree, twoxthree, threexthree, onexfour, twoxfour, threexfour ;

    @FXML
    public void getSuntoken( MouseEvent event) {
        suntoken.setVisible(false);
        addSun_tokens(25);
        number_suns.setText(String.valueOf(getSun_tokens()));

    }

    @FXML
    public void handleDragDetectedPeashooter(MouseEvent event) throws FileNotFoundException{
        if(getSun_tokens()>=100)
        {Dragboard db = peashooter_card.startDragAndDrop((TransferMode.ANY));
            ClipboardContent cb = new ClipboardContent();
            FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\peashooter.gif");
            Image peashooter_img = new Image(inputstream);
            cb.putImage(peashooter_img);
            cb.putString("pea");
            db.setContent(cb);
            event.consume();}
    }

    @FXML
    public void handleDragDetectedSunflower(MouseEvent event) throws FileNotFoundException{
        if(getSun_tokens()>=50)
        {Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
            ClipboardContent cb = new ClipboardContent();
            FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\sunflower.gif");
            Image peashooter_img = new Image(inputstream);
            cb.putImage(peashooter_img);
            cb.putString("sun");
            db.setContent(cb);
            event.consume();}
    }

    @FXML
    public void handleDragDetectedWalnut(MouseEvent event) throws FileNotFoundException{
        Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\Wallnut_body.png");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        cb.putString("walnut");
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
        cb.putString("cherry");
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
        String type = event.getDragboard().getString();
//        System.out.println(s);
        onexzero.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(onexzero);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(onexzero);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop20(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        twoxzero.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(twoxzero);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(twoxzero);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop30(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        threexzero.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(threexzero);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(threexzero);
            addSun_tokens(-50);
        }
    }

    @FXML
    public void handleDragDrop11(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        onexone.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(onexone);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(onexone);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop21(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        twoxone.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(twoxone);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(twoxone);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop31(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        threexone.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(threexone);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(threexone);
            addSun_tokens(-50);
        }
    }

    @FXML
    public void handleDragDrop12(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        onextwo.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(onextwo);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(onextwo);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop22(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        twoxtwo.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(twoxtwo);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(twoxtwo);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop32(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        threextwo.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(threextwo);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(threextwo);
            addSun_tokens(-50);
        }
    }

    @FXML
    public void handleDragDrop13(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        onexthree.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(onexthree);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(onexthree);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop23(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        twoxthree.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(twoxthree);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(twoxthree);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop33(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        threexthree.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(threexthree);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(threexthree);
            addSun_tokens(-50);
        }
    }

    @FXML
    public void handleDragDrop14(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        onexfour.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(onexfour);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(onexfour);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop24(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        twoxfour.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(twoxfour);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(twoxfour);
            addSun_tokens(-50);
        }
    }
    @FXML
    public void handleDragDrop34(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        String type = event.getDragboard().getString();
//        System.out.println(s);
        threexfour.setImage(peashooter_img);
        if (type.equalsIgnoreCase("pea")){
            plantAttack(threexfour);
            addSun_tokens(-100);
        }
        if (type.equalsIgnoreCase("sun")){
            sunGenerate(threexfour);
            addSun_tokens(-50);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zombiemove();
        suntoken_move(suntoken);
    }

    public void suntoken_move(ImageView  sun){
//        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(10), sun);
//        sun.setVisible(true);
//        translationElement.setFromY(sun.getLayoutY());
//        translationElement.setToY( sun.getLayoutY()+400 );
//        translationElement.setCycleCount(translationElement.INDEFINITE);
//        translationElement.play();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(sun.translateYProperty(), sun.getLayoutY(), new Interpolator() {
            double rest = sun.getLayoutY();
            @Override

            protected double curve(double v) {
                if(sun.getLayoutY()<500){
                    sun.setLayoutY(sun.getLayoutY()+1);
                }
                else{
                    sun.setVisible(true);
                    sun.setLayoutY(rest);
                    sun.setLayoutX(sun.getLayoutX()+10);
                }

                return 0;
            }
        });

        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();

    }

    public void sunGenerate(ImageView placeHolderPlant) throws FileNotFoundException {
        double posX= placeHolderPlant.getLayoutX()+placeHolderPlant.getFitWidth();
        double posY = placeHolderPlant.getLayoutY();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\backyard\\sun.gif");
        Image sunimg = new Image(inputstream);
        ImageView sunOfPlacedPlant = new ImageView(sunimg);
        sunOfPlacedPlant.setImage(null);
        sunOfPlacedPlant.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                sunOfPlacedPlant.setVisible(false);
                System.out.println("click");
                addSun_tokens(25);
                number_suns.setText(String.valueOf(getSun_tokens()));
                anchor.getChildren().remove(sunOfPlacedPlant);
                sunOfPlacedPlant.setImage(null);
            }
        });

        KeyValue keyvalue = new KeyValue(sunOfPlacedPlant.translateYProperty(), sunOfPlacedPlant.getLayoutY(), new Interpolator() {

            double rest = 300;
            int intermediate=0;
            @Override

            protected double curve(double v) {
                if(sunOfPlacedPlant.getImage()== null)
                { if(intermediate<rest){
                    intermediate= intermediate+1;
                }
                else{
                    sunOfPlacedPlant.setImage(sunimg);
                    anchor.getChildren().add(sunOfPlacedPlant);
                    sunOfPlacedPlant.setLayoutX(posX);
                    sunOfPlacedPlant.setLayoutY(posY);
                    System.out.println(sunOfPlacedPlant.getLayoutX());

                    sunOfPlacedPlant.setVisible(true);
                    intermediate=0;

                }}

                return 0;
            }
        });

        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();

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
        double posX= placeHolderPlant.getLayoutX()+placeHolderPlant.getFitWidth();
        double posY = placeHolderPlant.getLayoutY();
        System.out.println(posX);
        System.out.println(posY);
//        String number = placeHolderPlant.getId();
//        double amount = 0;
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\pea\\Pea.png");
        Image peaimg = new Image(inputstream);
        ImageView peaOfPlacedPlant = new ImageView(peaimg);
        anchor.getChildren().add(peaOfPlacedPlant);
//        System.out.println(placeHolderPlant.getImage());
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
        peaOfPlacedPlant.setLayoutX(posX);
        peaOfPlacedPlant.setLayoutY(posY);
        System.out.println(peaOfPlacedPlant.getLayoutX());
        peaOfPlacedPlant.setPreserveRatio(true);
//
        peaOfPlacedPlant.setVisible(true);
//        System.out.println("pea");
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(10), peaOfPlacedPlant);
        translationElement.setFromX(peaOfPlacedPlant.getX() );
        translationElement.setCycleCount(TranslateTransition.INDEFINITE);
        translationElement.setAutoReverse(false);
        translationElement.setToX( peaOfPlacedPlant.getX()+400 );

        translationElement.play();
    }


    public void checkCollision(ImageView a,ImageView b){
        System.out.println(a.getLayoutBounds().intersects(b.getLayoutBounds()));
        System.out.println(a.getLayoutBounds()+" layoutBound a x");
        System.out.println(b.getLayoutBounds());

    }
}

