package sample;

public abstract class Character {
    protected int health;
    protected int pos_x; protected int pos_y;
    protected String fx_id;


    public Character() {
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
}
