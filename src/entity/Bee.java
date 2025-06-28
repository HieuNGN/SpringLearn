package entity;

import java.util.Random;

public class Bee {
    private String type;
    private int health;
    private boolean alive;

    public Bee() {
//        this.type = type;
        this.health = 100;
        this.alive = true;
    }

    public String getType() {
        return type;
    }
    public int getHealth() {
        return health;
    }
    public boolean isAlive() {
        return alive;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void updateStatus() {
        if ("Queen".equals(this.getType()) && this.getHealth() <= 20) {
            setAlive(false);
        }
        else if ("Worker".equals(this.getType()) && this.getHealth() <= 50) {
            setAlive(false);
        }
        else setAlive(!"Drone".equals(this.getType()) || this.getHealth() > 75);
    }

    public void damage() {
        if (this.isAlive()) {
            Random rand = new Random();
            int damageAmount = rand.nextInt(100) + 1;
            int curHealth = this.getHealth() - damageAmount;

            if (curHealth > 0) {
                this.setHealth(curHealth);
            }
            else {
                this.setHealth(0);
            }
        }
    }
    @Override
    public String toString() {
        return this.getType() + "\t" + this.getHealth() + "\t" + (isAlive() ? "Alive" : "Dead");
    }
}
