package sample;

import java.util.ArrayList;

public class Game {
    private ArrayList<Level> arraylist_Levels = new ArrayList<>();
    private ArrayList<Player> list_Players = new ArrayList<>();
    protected  Player current_Player;

    public Game(String name){
        initialize_Level();
        current_Player = login(name);

    }

    private void initialize_Level(){

//        Level One = new Level(1);
//        arraylist_Levels.add(one);
    }
    private void add_Player_in_list(Player new_Player ){


    }

    private void load_Level (int level_number){

    }

    public void play_Game(int play_Level){

    }

    public Player login(String name){
        int index =-1;
        for(int i = 0; i<list_Players.size(); i++){
            if((list_Players.get(i).getUsername()).equals(name)){
                index = i;
            }

        }
        if(index != -1){
            return list_Players.get(index) ;
        }
        else {
            Player new_player= new Player(name);
            list_Players.add(new_player);
            return list_Players.get(list_Players.size()-1);
        }
    }

    public int choose_Level(){
        int current_Level= 1;
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
