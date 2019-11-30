package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Level1 extends Level implements Initializable {
    ArrayList<ImageView> zombies = null;
    ArrayList<Timeline> timelines = new ArrayList<>();
    ArrayList<ImageView> lawnmover = null;
    @FXML
    private Label number_suns;
    @FXML
    private Stage stage;
    @FXML
    Parent login;
    @FXML
    private AnchorPane pane,winpane;
    @FXML
    Button menubut, winbut;
    @FXML
    Parent mainscreen;
    @FXML
    private ImageView zombie1, suntoken, lawnmower1;
    @FXML
    private ImageView peashooter_card,progressbarhead, progressbar2,  peaOfPlacedPlant1, peaOfPlacedPlant2, peaOfPlacedPlant3, peaOfPlacedPlant4, peaOfPlacedPlant5, peaOfPlacedPlant6, peaOfPlacedPlant7, peaOfPlacedPlant8, peaOfPlacedPlant9, onexzero, twoxzero, threexzero, fourxzero, fivexzero, sixxzero, sevenxzero, eightxzero, ninexzero;

    public Level1 (){
        int number_of_Zombies= 3;


        number_Tracks= 1;

        level_Number =1;

        for(int j=0 ; j<number_Tracks; j++){
            String new_id  = "lawnmower";
            array_Lawnmower.add(new LawnMower(new_id+String.valueOf(j+1)));

        }

        plants_Available.add( new ProjectileShooter("peashooter_card"));


    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask()
    {
        public void run()
        {
            //The task you want to do
            zombiemove();
        }

    };

    private void createScene(Parent p,String fxmlfile,ActionEvent event) throws IOException {
        p =  FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene scene = new Scene(p);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
        stage.setScene(scene);
    }
    @FXML
    public void handleDragDetected(MouseEvent event) throws FileNotFoundException{
        if(getSun_tokens()>=50)
        {Dragboard db = peashooter_card.startDragAndDrop((TransferMode.ANY));
        ClipboardContent cb = new ClipboardContent();
        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\plant_gifs\\peashooter.gif");
        Image peashooter_img = new Image(inputstream);
        cb.putImage(peashooter_img);
        db.setContent(cb);
        event.consume();}
    }
    public void handlePlantCollision(ImageView plant){
        if(plant.getBoundsInParent().intersects(zombie1.getBoundsInParent())){
            System.out.println("collision between "+plant.getId()+" "+zombie1.getId()+" ");
        }
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
    public void handleDragDrop1(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        onexzero.setImage(peashooter_img);
        handlePlantCollision(onexzero);
        plantAttack(onexzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop2(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        twoxzero.setImage(peashooter_img);
        handlePlantCollision(twoxzero);
        plantAttack(twoxzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop3(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        threexzero.setImage(peashooter_img);
        handlePlantCollision(threexzero);
        plantAttack(threexzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop4(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        fourxzero.setImage(peashooter_img);
        handlePlantCollision(fourxzero);
        plantAttack(fourxzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop5(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        fivexzero.setImage(peashooter_img);
        handlePlantCollision(fivexzero);
        plantAttack(fivexzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop6(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        sixxzero.setImage(peashooter_img);
        handlePlantCollision(sixxzero);
        plantAttack(sixxzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }
    @FXML
    public void handleDragDrop7(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        sevenxzero.setImage(peashooter_img);
        handlePlantCollision(sevenxzero);
        plantAttack(sevenxzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }@FXML
    public void handleDragDrop8(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        eightxzero.setImage(peashooter_img);
        handlePlantCollision(eightxzero);
        plantAttack(eightxzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }@FXML
    public void handleDragDrop9(DragEvent event) throws FileNotFoundException{
        Image peashooter_img = event.getDragboard().getImage();
        ninexzero.setImage(peashooter_img);
        handlePlantCollision(ninexzero);
        plantAttack(ninexzero);
        setPlants_Used(new ProjectileShooter(onexzero.getId()));
        addSun_tokens(-100);
    }

    @FXML
    public void getSuntoken( MouseEvent event) {
        suntoken.setVisible(false);
        addSun_tokens(25);
        number_suns.setText(String.valueOf(getSun_tokens()));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        zombiemove();
        progressbar();
        suntoken_move(suntoken);
        checkCollisionLawnmower(zombies);
//        gameWin();




    }

    public ArrayList<ImageView> makeZombie() throws FileNotFoundException {
        Random rand = new Random();
        int x = 600;
        int num = rand.nextInt(5)+1;
        ArrayList<ImageView> zombies = new ArrayList<>();
        for (int i = 0;i<num;i++){
            FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\zombie_gifs\\zombie_normal.gif");
            Image zombieimg = new Image(inputstream);
            ImageView zombie = new ImageView(zombieimg);
            zombie.setId("zombie"+String.valueOf(i));
            zombies.add(zombie);
            pane.getChildren().add(zombie);
            zombie.setLayoutX(x);
            zombie.setLayoutY(100);
            zombie.setFitWidth(50);
            zombie.setFitHeight(100);
            arrayList_Zombie.add(new Zombie("zombie"+String.valueOf(i)));
            x += 100;
        }
        return zombies;

    }
    public void progressbar(){
        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), progressbarhead);
        translationElement.setCycleCount(1);
        translationElement.setFromX(progressbarhead.getX() );
        translationElement.setToX( progressbarhead.getX()-160);

        translationElement.play();
    }

    public void zombiemove() {


//        TranslateTransition translationElement = new TranslateTransition(Duration.seconds(30), zombie1);
//        translationElement.setFromX(zombie1.getX() );
//        translationElement.setToX( zombie1.getX()-400 );
//        translationElement.setCycleCount(1);
//        translationElement.play();
//        // to make the the image invisible
//        translationElement.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                zombie1.setVisible(false);
//            }
//        });

        try {
            zombies = makeZombie();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = -500;
        for(int i = 0;i<zombies.size();i++){
            Timeline timeline = new Timeline();
            timelines.add(timeline);
            KeyValue keyvalue = new KeyValue(zombies.get(i).translateXProperty(),t);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(50),keyvalue);
            timeline.getKeyFrames().add(keyframe);
            timeline.play();
            t -= 100;
        }





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

//    public void gameWin(){
//        Timeline timeline = new Timeline();
//        timeline.setCycleCount(timeline.INDEFINITE);
//
//        KeyValue keyvalue = new KeyValue(onexzero.translateXProperty(), 100, new Interpolator() {
//            @Override
//            protected double curve(double v) {
//                boolean flag = false;
//                for(int i = 0;i<arrayList_Zombie.size();i++){
//                    if(arrayList_Zombie.get(i).getHealth()!=0){
//                        flag = true;
//                    }
//                }
//                if(!flag){
////
//                    pane.setVisible(false);
//                    pane.setDisable(true);
////                    winpane.setDisable(false);
////                    winpane.setVisible(true);
//
//
//
//                }
//                return 0;
//            }
//        });
//        KeyFrame keyframe = new KeyFrame(Duration.seconds(5),keyvalue);
//        timeline.getKeyFrames().add(keyframe);
//        timeline.play();
//
//    }

    public void plantAttack(ImageView placeHolderPlant) throws FileNotFoundException{
        double posX= placeHolderPlant.getLayoutX()+placeHolderPlant.getFitWidth();
        double posY = placeHolderPlant.getLayoutY();
        System.out.println(posX);
        System.out.println(posY);
        String number = placeHolderPlant.getId();
        double amount = 0;
        ImageView peaOfPlacedPlant = null;

        FileInputStream inputstream = new FileInputStream("C:\\PlantsVsZombies\\Main_Game\\src\\sample\\pvz_images\\pea\\Pea.png");
        Image peaimg = new Image(inputstream);
       peaOfPlacedPlant = new ImageView(peaimg);
        pane.getChildren().add(peaOfPlacedPlant);


        peaOfPlacedPlant.setLayoutX(posX);
        peaOfPlacedPlant.setLayoutY(posY);

        peaOfPlacedPlant.setVisible(true);
        System.out.println("pea");

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
                for(int i = 0;i<zombies.size();i++){
                    if(placeHolderPlant.getBoundsInParent().intersects(zombies.get(i).getBoundsInParent())){

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
                    if(zombies.get(i)!=null)
                        checkCollision(finalPeaOfPlacedPlant,zombies.get(i));
                }
                boolean flag=false;

                return 0;
            }
        });
        KeyFrame keyframe = new KeyFrame(Duration.seconds(10),keyvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();


    }


    @FXML
    public void quitButtonPressed(ActionEvent event) throws IOException {
        createScene(mainscreen,"mainpage.fxml",event);
    }

    @FXML
    public void mainmenu(ActionEvent event) throws IOException {
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
    public void onSaveGame(ActionEvent event) throws IOException {



    }

    public void checkCollision(ImageView a,ImageView b){
//        System.out.println("collision between "+ a.getId()+" " +b.getId()+ " "+ a.getBoundsInParent().intersects(b.getBoundsInParent()));
//        System.out.println(a.getLayoutX());
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
//        System.out.println(a.getBoundsInParent()+" layoutBound a x");
//        System.out.println(b.getBoundsInParent());

    }

//    public void lawnmowermove() {
//
//
//
//        int t = 400;
//
//            Timeline timeline = new Timeline();
//            timelines.add(timeline);
//            KeyValue keyvalue = new KeyValue(lawnmower1.translateXProperty(),t);
//            KeyFrame keyframe = new KeyFrame(Duration.seconds(10),keyvalue);
//            timeline.getKeyFrames().add(keyframe);
//            timeline.play();
//
//
//
//
//
//
//
//    }

    public void checkCollisionLawnmower( ArrayList<ImageView> zombie){
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
                for(int i = 0;i<zombies.size();i++){
                    if(!zombies.get(i).isVisible()){

                        counter++;
                    }
                }
                if(counter == zombies.size()){
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

}