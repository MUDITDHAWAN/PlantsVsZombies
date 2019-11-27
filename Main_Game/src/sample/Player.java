package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable,Comparable<Player> {
    private int suntoken;
    private int coins;

    private int level;
    private ArrayList<Plant> unlocked_plants; //have to initialize this or will get a null pointer error
    private String username;

    public Player(String s){
        unlocked_plants = new ArrayList<>();
        username = s;
    }

    public void placePlant(){

    }

    public int getSuntoken() {
        return suntoken;
    }

    public void setSuntoken(int suntoken) {
        this.suntoken = suntoken;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Plant> getUnlocked_plants() {
        return unlocked_plants;
    }

    public void setUnlocked_plants(ArrayList<Plant> unlocked_plants) {
        this.unlocked_plants = unlocked_plants;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }
}

