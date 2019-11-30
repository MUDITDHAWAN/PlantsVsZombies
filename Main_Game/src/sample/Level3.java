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
import javafx.scene.control.Button;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Level3 extends Level implements Initializable {
    ArrayList<ImageView> zombies1 ;
    ArrayList<ImageView> zombies2;
    ArrayList<ImageView> zombies3 ;
    ArrayList<ImageView> zombies4 ;
    ArrayList<ImageView> zombies5 ;
    ArrayList<Timeline> timelines = new ArrayList<>();
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

    public ArrayList<ImageView> makeZombie(int row) throws FileNotFoundException {
        Random rand = new Random();
        int x = 600;
        int y = 10;
        int num = rand.nextInt(5)+1;
        ArrayList<ImageView> zombies = new ArrayList<>();
        for (int i = 0;i<num;i++){
            FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\zombie_gifs\\zombie_normal.gif");
            Image zombieimg = new Image(inputstream);
            ImageView zombie = new ImageView(zombieimg);
            inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\zombie_gifs\\Conehead_zombie.png");
            Image zombieconeimg = new Image(inputstream);
            ImageView zombiecone = new ImageView(zombieconeimg);
            int whichzombie = rand.nextInt(2);
            if(whichzombie==1){
                zombie.setId("zombie"+String.valueOf(i) + String.valueOf(row));
                zombies.add(zombie);
                anchor.getChildren().add(zombie);
                zombie.setLayoutX(x);
                zombie.setLayoutY(y*row*7);
                zombie.setFitWidth(50);
                zombie.setFitHeight(80);
                arrayList_Zombie.add(new Zombie("zombie"+String.valueOf(i)+String.valueOf(row)));
            }
            else{
                zombiecone.setId("zombiecone"+String.valueOf(i) + String.valueOf(row));
                zombies.add(zombiecone);
                anchor.getChildren().add(zombiecone);
                zombiecone.setLayoutX(x);
                zombiecone.setLayoutY(y*row*7);
                zombiecone.setFitWidth(50);
                zombiecone.setFitHeight(80);
                Zombie toadd = new Zombie("zombiecone"+String.valueOf(i)+String.valueOf(row));
                toadd.setHealth(200);
                arrayList_Zombie.add(toadd);
            }

            x += 100*(rand.nextInt(level_Number*2)+1)/2;
        }
        return zombies;
    }
    @FXML
    Parent mainscreen;
@FXML
    Button winbut;
    @FXML
    Stage stage;
    @FXML
    private AnchorPane anchor;

    @FXML
    private Label number_suns;
    @FXML
    private ImageView lawnmower1, progressbarhead, progressbar2,lawnmower2, lawnmower3, lawnmower4, lawnmower5, suntoken, peashooter_card,sunflower_card,walnut_card, cherrybomb_card, onexzero, twoxzero, threexzero, onexone, twoxone, threexone, onextwo, twoxtwo, threextwo, onexthree, twoxthree, threexthree, onexfour, twoxfour, threexfour ;

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
        if(getSun_tokens()>=50)
        {Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\Wallnut_body.png");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        cb.putString("walnut");
        db.setContent(cb);
        event.consume();}
    }
    @FXML
    public void handleDragDetectedCherrybomb(MouseEvent event) throws FileNotFoundException{
        if(getSun_tokens()>=150)
        {Dragboard db = sunflower_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\cherrybomb.png");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        cb.putString("cherry");
        db.setContent(cb);
        event.consume();}
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
        if (type.equalsIgnoreCase("walnut")){

            addSun_tokens(-50);
            barrierhold(onexzero);
        }
        if (type.equalsIgnoreCase("cherry")){

            addSun_tokens(-150);
            plantBombCollision(onexzero);
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
            addSun_tokens(-50);
            sunGenerate(twoxzero);

        }
        if (type.equalsIgnoreCase("walnut")){

            addSun_tokens(-50);
            barrierhold(twoxzero);
        }
        if (type.equalsIgnoreCase("cherry")){

            addSun_tokens(-150);
            plantBombCollision(twoxzero);
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
            addSun_tokens(-50);
            sunGenerate(threexzero);



        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);
            barrierhold(threexzero);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(threexzero);
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
            addSun_tokens(-50);
            sunGenerate(onexone);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(onexone);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(onexone);

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
            addSun_tokens(-50);
            sunGenerate(twoxone);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(twoxone);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(twoxone);

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
            addSun_tokens(-50);
            sunGenerate(threexone);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(threexone);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(threexone);
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
            addSun_tokens(-50);
            sunGenerate(onextwo);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(onextwo);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(onextwo);
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
            addSun_tokens(-50);
            sunGenerate(twoxtwo);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(twoxtwo);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(twoxtwo);
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
            addSun_tokens(-50);
            sunGenerate(threextwo);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(threextwo);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(threextwo);

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
            addSun_tokens(-50);
            sunGenerate(onexthree);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(onexthree);

        }
        if (type.equalsIgnoreCase("cherry")){
            plantBombCollision(onexthree);
            addSun_tokens(-150);

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
            addSun_tokens(-50);
            sunGenerate(twoxthree);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(twoxthree);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(twoxthree);

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
            addSun_tokens(-50);
            sunGenerate(threexthree);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(threexthree);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(threexthree);

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
            addSun_tokens(-50);
            sunGenerate(onexfour);

        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(onexfour);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(onexfour);

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
            addSun_tokens(-50);
            sunGenerate(twoxfour);



        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(twoxfour);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(twoxfour);

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
            addSun_tokens(-50);
            sunGenerate(threexfour);



        }
        if (type.equalsIgnoreCase("walnut")){
            addSun_tokens(-50);barrierhold(threexfour);

        }
        if (type.equalsIgnoreCase("cherry")){
            addSun_tokens(-150);
            plantBombCollision(threexfour);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressbar();
        zombiemove1();
        zombiemove2();
        zombiemove3();
        zombiemove4();
        zombiemove5();
        suntoken_move(suntoken);
        checkCollisionLawnmower1(zombies1);
        checkCollisionLawnmower2(zombies2);
        checkCollisionLawnmower3(zombies3);
        checkCollisionLawnmower4(zombies4);
        checkCollisionLawnmower5(zombies5);
    }

    public void suntoken_move(ImageView  sun){
//        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(10), sun);
//        sun.setVisible(true);
//        translationElement.setFromY(sun.getLayoutY());
//        translationElement.setToY( sun.getLayoutY()+400 );
//        translationElement.setCycleCount(translationElement.INDEFINITE);
//        translationElement.play();

        Timeline timeline = new Timeline();
        timelines.add(timeline);
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
    public void zombiemove1() {
//
        zombies1 = null;
        try {
            zombies1 = makeZombie(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -700;
        for(int i = 0;i<zombies1.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies1.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(100),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }

    }
    public void zombiemove2() {
//
        zombies2 = null;
        try {
            zombies2 = makeZombie(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -700;
        for(int i = 0;i<zombies2.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies2.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(100),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }

    }
    public void progressbar(){
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), progressbarhead);
        translationElement.setCycleCount(1);
        translationElement.setFromX(progressbarhead.getX() );
        translationElement.setToX( progressbarhead.getX()-160);

        translationElement.play();
    }
    public void zombiemove3() {
//
        zombies3 = null;
        try {
            zombies3 = makeZombie(3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -700;
        for(int i = 0;i<zombies3.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies3.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(100),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }

    }
    public void zombiemove4() {
//
        zombies4 = null;
        try {
            zombies4 = makeZombie(4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -700;
        for(int i = 0;i<zombies4.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies4.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(100),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }

    }
    public void zombiemove5() {
//
        zombies5 = null;
        try {
            zombies5 = makeZombie(5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -700;
        for(int i = 0;i<zombies5.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies5.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(100),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }

    }

    public void barrierhold(ImageView placeHolderPlant){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);
        final int[] counter = {10};
        KeyValue keyvalue = new KeyValue(placeHolderPlant.translateXProperty(), placeHolderPlant.getLayoutX(), new Interpolator() {
            @Override

            protected double curve(double v) {
                for(int i = 0;i<zombies1.size();i++){
                    if(zombies1.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())&& counter[0] >0){
                        zombies1.get(i).setLayoutX(zombies1.get(i).getLayoutX()+10);
                        counter[0]--;

                    }
                }
                for(int i = 0;i<zombies2.size();i++){
                    if(zombies2.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())&& counter[0] >0){
                        zombies2.get(i).setLayoutX(zombies2.get(i).getLayoutX()+10);
                        counter[0]--;

                    }
                }
                for(int i = 0;i<zombies3.size();i++){
                    if(zombies3.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())&& counter[0] >0){
                        zombies3.get(i).setLayoutX(zombies3.get(i).getLayoutX()+10);
                        counter[0]--;

                    }
                }
                for(int i = 0;i<zombies4.size();i++){
                    if(zombies4.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())&& counter[0] >0){
                        zombies4.get(i).setLayoutX(zombies4.get(i).getLayoutX()+10);
                        counter[0]--;

                    }
                }
                for(int i = 0;i<zombies5.size();i++){
                    if(zombies5.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())&& counter[0] >0){
                        zombies5.get(i).setLayoutX(zombies5.get(i).getLayoutX()+10);
                        counter[0]--;

                    }
                }
                if (counter[0]<=0){
                    placeHolderPlant.setVisible(false);
                }
                return 0;
            }
        });

            KeyFrame keyframe = new KeyFrame(Duration.seconds(10), keyvalue);
        timeline.getKeyFrames().

            add(keyframe);
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
                for(int i = 0;i<zombies1.size();i++){
                    if(zombies1.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())){
                        placeHolderPlant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies2.size();i++){
                    if(zombies2.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())){
                        placeHolderPlant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies3.size();i++){
                    if(zombies3.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())){
                        placeHolderPlant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies4.size();i++){
                    if(zombies4.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())){
                        placeHolderPlant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies5.size();i++){
                    if(zombies5.get(i).getBoundsInParent().intersects(placeHolderPlant.getBoundsInParent())){
                        placeHolderPlant.setVisible(false);
                    }
                }

                return 0;
            }
        });

        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();

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
//
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
        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);
        ImageView finalPeaOfPlacedPlant = peaOfPlacedPlant;
        KeyValue keyvalue = new KeyValue(peaOfPlacedPlant.translateXProperty(), 400, new Interpolator() {

            double posx = finalPeaOfPlacedPlant.getLayoutX();
            double posy = finalPeaOfPlacedPlant.getLayoutY();
            @Override
            protected double curve(double v) {
//                for(int i=0; i<plants_Used.size(); i++){
//                    System.out.println(plants_Used.get(i));
//                }
                for(int i = 0;i<zombies1.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies1.get(i).getBoundsInParent())){

//                    System.out.println("collision between "+placeHolderPlant.getId()+" "+zombie1.getId());

                        placeHolderPlant.setVisible(false);
                        finalPeaOfPlacedPlant.setVisible(false);

                        finalPeaOfPlacedPlant.setLayoutX(-200000);
                    }
                    if (finalPeaOfPlacedPlant.getLayoutX()<600){
                        finalPeaOfPlacedPlant.setLayoutX(finalPeaOfPlacedPlant.getLayoutX()+0.5);
                    }
                    else{
                        finalPeaOfPlacedPlant.setLayoutX(posx);
                        finalPeaOfPlacedPlant.setLayoutY(posy);
                        finalPeaOfPlacedPlant.setVisible(true);
                    }
                    if(zombies1.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies1.get(i));
                }

                for(int i = 0;i<zombies2.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies2.get(i).getBoundsInParent())){

//                    System.out.println("collision between "+placeHolderPlant.getId()+" "+zombie1.getId());

                        placeHolderPlant.setVisible(false);
                        finalPeaOfPlacedPlant.setVisible(false);

                        finalPeaOfPlacedPlant.setLayoutX(-200000);
                    }
                    if (finalPeaOfPlacedPlant.getLayoutX()<600){
                        finalPeaOfPlacedPlant.setLayoutX(finalPeaOfPlacedPlant.getLayoutX()+0.1);
                    }
                    else{
                        finalPeaOfPlacedPlant.setLayoutX(posx);
                        finalPeaOfPlacedPlant.setLayoutY(posy);
                        finalPeaOfPlacedPlant.setVisible(true);
                    }
                    if(zombies2.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies2.get(i));
                }

                for(int i = 0;i<zombies3.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies3.get(i).getBoundsInParent())){

//                    System.out.println("collision between "+placeHolderPlant.getId()+" "+zombie1.getId());

                        placeHolderPlant.setVisible(false);
                        finalPeaOfPlacedPlant.setVisible(false);

                        finalPeaOfPlacedPlant.setLayoutX(-200000);
                    }
                    if (finalPeaOfPlacedPlant.getLayoutX()<600){
                        finalPeaOfPlacedPlant.setLayoutX(finalPeaOfPlacedPlant.getLayoutX()+0.1);
                    }
                    else{
                        finalPeaOfPlacedPlant.setLayoutX(posx);
                        finalPeaOfPlacedPlant.setLayoutY(posy);
                        finalPeaOfPlacedPlant.setVisible(true);
                    }
                    if(zombies3.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies3.get(i));
                }
                for(int i = 0;i<zombies4.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies4.get(i).getBoundsInParent())){

//                    System.out.println("collision between "+placeHolderPlant.getId()+" "+zombie1.getId());

                        placeHolderPlant.setVisible(false);
                        finalPeaOfPlacedPlant.setVisible(false);

                        finalPeaOfPlacedPlant.setLayoutX(-200000);
                    }
                    if (finalPeaOfPlacedPlant.getLayoutX()<600){
                        finalPeaOfPlacedPlant.setLayoutX(finalPeaOfPlacedPlant.getLayoutX()+0.1);
                    }
                    else{
                        finalPeaOfPlacedPlant.setLayoutX(posx);
                        finalPeaOfPlacedPlant.setLayoutY(posy);
                        finalPeaOfPlacedPlant.setVisible(true);
                    }
                    if(zombies4.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies4.get(i));
                }
                for(int i = 0;i<zombies5.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies5.get(i).getBoundsInParent())){

//                    System.out.println("collision between "+placeHolderPlant.getId()+" "+zombie1.getId());

                        placeHolderPlant.setVisible(false);
                        finalPeaOfPlacedPlant.setVisible(false);

                        finalPeaOfPlacedPlant.setLayoutX(-200000);
                    }
                    if (finalPeaOfPlacedPlant.getLayoutX()<600){
                        finalPeaOfPlacedPlant.setLayoutX(finalPeaOfPlacedPlant.getLayoutX()+0.1);
                    }
                    else{
                        finalPeaOfPlacedPlant.setLayoutX(posx);
                        finalPeaOfPlacedPlant.setLayoutY(posy);
                        finalPeaOfPlacedPlant.setVisible(true);
                    }
                    if(zombies5.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies5.get(i));
                }
                return 0;
            }
        });
        KeyFrame keyframe = new KeyFrame(Duration.seconds(30),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();


    }

    public void plantCollision(ImageView plant){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(plant.translateXProperty(), plant.getLayoutX(), new Interpolator() {
            @Override
            protected double curve(double v) {
                for(int i = 0;i<zombies1.size();i++){
                    if(zombies1.get(i).getBoundsInParent().intersects(plant.getBoundsInParent())){
                        plant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies2.size();i++){
                    if(zombies2.get(i).getBoundsInParent().intersects(plant.getBoundsInParent())){
                        plant.setVisible(false);
                    }
                }
                for(int i = 0;i<zombies3.size();i++){
                    if(zombies3.get(i).getBoundsInParent().intersects(plant.getBoundsInParent())){
                        plant.setVisible(false);
                    }
                }
                return 0;
            }
        });
        KeyFrame keyframe = new KeyFrame(Duration.seconds(10),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
    }

    public void plantBombCollision(ImageView plant){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(plant.translateXProperty(), plant.getLayoutX(), new Interpolator() {
            @Override
            protected double curve(double v) {
                for (int j = 0; j < zombies1.size(); j++){
                    ImageView b = zombies1.get(j);
                    if (plant.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                plant.setLayoutX(plant.getLayoutY()+3000);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                        plant.setVisible(false);
                    }}
                for(int j = 0;j<zombies2.size();j++){
                    ImageView b = zombies2.get(j);
                    if (plant.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                plant.setLayoutX(plant.getLayoutY()+3000);
                                plant.setVisible(false);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }

                    }
                }
                for(int j = 0;j<zombies3.size();j++){
                    ImageView b = zombies3.get(j);
                    if (plant.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                plant.setLayoutX(plant.getLayoutY()+3000);
                                plant.setVisible(false);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }

                    }
                }
                for(int j = 0;j<zombies4.size();j++){
                    ImageView b = zombies4.get(j);
                    if (plant.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                plant.setLayoutX(plant.getLayoutY()+3000);
                                plant.setVisible(false);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }

                    }
                }

                for(int j = 0;j<zombies5.size();j++){
                    ImageView b = zombies5.get(j);
                    if (plant.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                plant.setLayoutX(plant.getLayoutY()+3000);
                                plant.setVisible(false);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }

                    }
                }
                return 0;
            }
        });
        KeyFrame keyframe = new KeyFrame(Duration.seconds(10),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
    }

    public void checkCollision(ImageView a,ImageView b){
        if (a.getBoundsInParent().intersects(b.getBoundsInParent())){
            a.setVisible(false);

            a.setLayoutY(a.getLayoutY()+3000);
            for(int i =0; i<arrayList_Zombie.size(); i++){
                if((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())){
                    arrayList_Zombie.get(i).decrementHealth(20);
                    System.out.println(arrayList_Zombie.get(i).getHealth());
                    if(arrayList_Zombie.get(i).getHealth()==0){
                        b.setVisible(false);
                        b.setLayoutX(b.getLayoutX()-1000);
//                        pane.getChildren().remove(b);
                    }
                }
            }
        }
    }

    @FXML
    public void onSaveGame(ActionEvent event) throws IOException {



    }

    public void checkCollisionLawnmower1( ArrayList<ImageView> zombie){
        // a lawnmower
        // b zombie

        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(lawnmower1.translateXProperty(), lawnmower1.getLayoutX(), new Interpolator() {



            int flag=1;
            @Override
            protected double curve(double v) {

                for (int j = 0; j < zombie.size(); j++){
                    ImageView b = zombie.get(j);
                    if (lawnmower1.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                flag =0;
                                lawnmower1.setLayoutX(lawnmower1.getLayoutX()+0.5);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                    }}
                if(flag==0){
                    lawnmower1.setLayoutX(lawnmower1.getLayoutX()+5);
                }
                int counter = 0;
                for(int i = 0;i<zombies1.size();i++){
                    if(!zombies1.get(i).isVisible()){

                        counter++;
                    }
                }
                for(int i = 0;i<zombies2.size();i++){
                    if(!zombies2.get(i).isVisible()){

                        counter++;
                    }
                }
                for(int i = 0;i<zombies3.size();i++){
                    if(!zombies3.get(i).isVisible()){

                        counter++;
                    }
                }
                for(int i = 0;i<zombies4.size();i++){
                    if(!zombies4.get(i).isVisible()){

                        counter++;
                    }
                }
                for(int i = 0;i<zombies5.size();i++){
                    if(!zombies5.get(i).isVisible()){

                        counter++;
                    }
                }
                if(counter == zombies1.size()+zombies2.size()+zombies3.size()+zombies4.size()+zombies5.size()){
//
//                    pane.setVisible(false);
//                    pane.setDisable(true);
//                    winpane.setDisable(false);
//                    winpane.setVisible(true);
//                    System.out.println("test");
                    winbut.setVisible(true);


                }


                return 0;
            }
        });


        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());

//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

    public void checkCollisionLawnmower2( ArrayList<ImageView> zombie){
        // a lawnmower
        // b zombie

        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(lawnmower2.translateXProperty(), lawnmower2.getLayoutX(), new Interpolator() {



            int flag=1;
            @Override
            protected double curve(double v) {

                for (int j = 0; j < zombie.size(); j++){
                    ImageView b = zombie.get(j);
                    if (lawnmower2.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                flag =0;
                                lawnmower2.setLayoutX(lawnmower2.getLayoutX()+0.5);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                    }}
                if(flag==0){
                    lawnmower2.setLayoutX(lawnmower2.getLayoutX()+5);
                }

                return 0;
            }
        });


        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());

//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

    public void checkCollisionLawnmower3( ArrayList<ImageView> zombie){
        // a lawnmower
        // b zombie

        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(lawnmower3.translateXProperty(), lawnmower3.getLayoutX(), new Interpolator() {



            int flag=1;
            @Override
            protected double curve(double v) {

                for (int j = 0; j < zombie.size(); j++){
                    ImageView b = zombie.get(j);
                    if (lawnmower3.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                flag =0;
                                lawnmower3.setLayoutX(lawnmower3.getLayoutX()+0.5);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                    }}
                if(flag==0){
                    lawnmower3.setLayoutX(lawnmower3.getLayoutX()+5);
                }

                return 0;
            }
        });


        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());

//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

    public void checkCollisionLawnmower4( ArrayList<ImageView> zombie){
        // a lawnmower
        // b zombie

        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(lawnmower4.translateXProperty(), lawnmower4.getLayoutX(), new Interpolator() {



            int flag=1;
            @Override
            protected double curve(double v) {

                for (int j = 0; j < zombie.size(); j++){
                    ImageView b = zombie.get(j);
                    if (lawnmower4.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                flag =0;
                                lawnmower4.setLayoutX(lawnmower4.getLayoutX()+0.5);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                    }}
                if(flag==0){
                    lawnmower4.setLayoutX(lawnmower4.getLayoutX()+5);
                }

                return 0;
            }
        });


        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());

//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

    public void checkCollisionLawnmower5( ArrayList<ImageView> zombie){
        // a lawnmower
        // b zombie

        Timeline timeline = new Timeline();
        timelines.add(timeline);
        timeline.setCycleCount(timeline.INDEFINITE);

        KeyValue keyvalue = new KeyValue(lawnmower2.translateXProperty(), lawnmower2.getLayoutX(), new Interpolator() {



            int flag=1;
            @Override
            protected double curve(double v) {

                for (int j = 0; j < zombie.size(); j++){
                    ImageView b = zombie.get(j);
                    if (lawnmower5.getBoundsInParent().intersects(b.getBoundsInParent())) {

                        for (int i = 0; i < arrayList_Zombie.size(); i++) {
                            if ((b.getId()).equals(arrayList_Zombie.get(i).getFx_id())) {
                                arrayList_Zombie.get(i).setHealth(0);
                                flag =0;
                                lawnmower5.setLayoutX(lawnmower5.getLayoutX()+0.5);
                                System.out.println(arrayList_Zombie.get(i).getHealth());
                                if (arrayList_Zombie.get(i).getHealth() == 0) {
                                    b.setVisible(false);
                                    b.setLayoutX(b.getLayoutX() - 10000);

                                }
                            }
                        }
                    }}
                if(flag==0){
                    lawnmower5.setLayoutX(lawnmower5.getLayoutX()+5);
                }

                return 0;
            }
        });


        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());

//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

    @FXML
    public void quitButtonPressed(ActionEvent event) throws IOException {
        createScene(mainscreen,"mainpage.fxml",event);
    }
    @FXML
    public void onPause(ActionEvent event){
        for(int i = 0;i<timelines.size();i++){
            timelines.get(i).pause();
        }

    }
    @FXML
    public void onPlay(){
        for(int i = 0;i<timelines.size();i++){
            timelines.get(i).play();
        }
    }
    @FXML
    public void mainmenu(ActionEvent event) throws IOException {
        createScene(mainscreen,"mainpage.fxml",event);
    }
    private void createScene(Parent p,String fxmlfile,ActionEvent event) throws IOException {
        p =  FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene scene = new Scene(p);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
        stage.setScene(scene);
    }
}


