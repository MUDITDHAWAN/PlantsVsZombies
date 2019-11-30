package sample;

import java.io.Serializable;

public abstract class Character implements Serializable {
    protected int health= 100;
    protected int pos_x; protected int pos_y;
    protected String fx_id;


    public Character(String id) {
        fx_id= id;
    }

    protected void setPosition(int x, int y){
        pos_x = x;
        pos_y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decrementHealth(int value){
        this.health= this.health- value;
    }

    public String getFx_id(){ return fx_id;}


}
