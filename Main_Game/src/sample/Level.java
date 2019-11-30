package sample;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;

public class Level implements Serializable {
    protected int sun_tokens;
    protected ArrayList<Zombie> arrayList_Zombie = new ArrayList<>();
    protected int number_Tracks;
    protected int level_Number;
    protected ArrayList<LawnMower> array_Lawnmower = new ArrayList<>();
    protected ArrayList<Plant> plants_Available  = new ArrayList<>();
    public ArrayList<Plant> plants_Used = new ArrayList<>();

    public ArrayList<Zombie> getArrayList_Zombie(){ return arrayList_Zombie;}

    public int getNumber_Tracks(){ return number_Tracks;}

    public int getLevel_Number(){ return level_Number;}

    public ArrayList<LawnMower> getArray_Lawnmower(){ return array_Lawnmower;}

    public ArrayList<Plant> getPlants_Available() { return plants_Available; }

    public ArrayList<Plant> getPlants_Used(){ return plants_Used;}

    public int getSun_tokens() {
        return sun_tokens;
    }

    public void addSun_tokens(int sun_tokens) {
        this.sun_tokens = this.sun_tokens+ sun_tokens;
    }

    public void setPlants_Used(Plant new_Plant){
        plants_Used.add(new_Plant);
    }

}
