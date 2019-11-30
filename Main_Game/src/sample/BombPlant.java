package sample;

public class BombPlant extends Plant {
    private int blast_radius;
    private int setup_time;

    public BombPlant(String id) {
        super(id);
    }
    public void blowup(){

    }

    public int getBlast_radius() {
        return blast_radius;
    }

    public void setBlast_radius(int blast_radius) {
        this.blast_radius = blast_radius;
    }

    public int getSetup_time() {
        return setup_time;
    }

    public void setSetup_time(int setup_time) {
        this.setup_time = setup_time;
    }
}
