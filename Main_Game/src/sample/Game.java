package sample;

import java.util.ArrayList;

public class Game {
    private ArrayList<Level> arraylist_Levels = new ArrayList<>();
    private ArrayList<Player> list_Players = new ArrayList<>();
    protected  Player current_Player;

    public Game(){

    }

    private void initialize_Level(){
//        Level One = new Level(1);

    }
    private void add_Player_in_list(Player new_Player ){


    }

    private void load_Level (int level_number){

    }

    public void play_Game(int play_Level){

    }

    public void login(){
        int current_index=2;
        current_Player= list_Players.get(current_index); // player to start playing the game
    }

    public int choose_Level(){
        int current_Level= 2;
        return current_Level;
    }

    public ArrayList<Level> getList_Levels() {
        return arraylist_Levels;
    }

    public ArrayList<Player> getList_Player() {
        return list_Players;
    }

    public void serialze(){

    }

    public void deserialize(){

    }


}
