package sample;

public class BarrierPlant extends Plant {
    private int hold_time;

    public BarrierPlant(String id) {
        super(id);
    }

    public int getHold_time() {
        return hold_time;
    }

    public void setHold_time(int hold_time) {
        this.hold_time = hold_time;
    }
}
