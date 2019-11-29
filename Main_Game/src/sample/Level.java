package sample;

import java.sql.Array;
import java.util.ArrayList;

public class Level {
    protected ArrayList<Zombie> arrayList_Zombie ;
    protected int number_Tracks;
    protected int level_Number;
    protected ArrayList<LawnMower> array_Lawnmower;
    protected ArrayList<Plant> plants_Available;
    public ArrayList<Plant> plants_Used;

    public ArrayList<Zombie> getArrayList_Zombie(){ return arrayList_Zombie;}

    public int getNumber_Tracks(){ return number_Tracks;}

    public int getLevel_Number(){ return level_Number;}

    public ArrayList<LawnMower> getArray_Lawnmower(){ return array_Lawnmower;}

    public ArrayList<Plant> getPlants_Available() { return plants_Available; }

    public ArrayList<Plant> getPlants_Used(){ return plants_Used;}

    public void setPlants_Used(Plant new_Plant){
        plants_Used.add(new_Plant);
    }

}
