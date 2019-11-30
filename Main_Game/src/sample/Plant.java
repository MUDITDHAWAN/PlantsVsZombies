package sample;

public class Plant extends Character {
    private int recharge;
    private int cost;

    public Plant(String id) {
        super(id);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRecharge() {
        return recharge;
    }

    public void setRecharge(int recharge) {
        this.recharge = recharge;
    }
}
