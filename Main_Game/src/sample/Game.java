package sample;

import java.util.ArrayList;

public class Game {
    private ArrayList<Level> arraylist_Levels;
    private ArrayList<Player> list_Players;
    protected  Player current_Player;

    private void initialize_Level(){

    }
    private void add_Player_in_list(Player new_Player ){


    }

    private void load_Level (int level_number){

    }

    public void play_Game(int play_Level){

    }

    public void login(){
        int current_index;
        current_Player= list_Players.get(current_index); // player to start playing the game
    }

    public int choose_Level(){
        int current_Level;
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
