package business;

import entity.Bee;
import entity.Drone;
import entity.QueenBee;
import entity.WorkerBee;

import java.util.ArrayList;
import java.util.Random;

public class BeeHive {

    private ArrayList<Bee> bees = new ArrayList<>();

    public void initBeeHive() {
        for (int i = 0; i < 10; i++) {
            bees.add(createRandomBee());
        }
    }

    private Bee createRandomBee() {
        Random random = new Random();
        int beeType = random.nextInt(3);
        return switch (beeType) {
            case 0 -> new QueenBee();
            case 1 -> new WorkerBee();
            default -> new Drone();
        };
    }

    public ArrayList<Bee> getBees() {
        return bees;
    }

    public void attackBees() {
        for (Bee bee : bees) {
            bee.damage();
            bee.updateStatus();
        }
    }
}
