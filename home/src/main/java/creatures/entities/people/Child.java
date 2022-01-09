package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

import java.io.IOException;
import java.util.Random;

public class Child extends Person {

    private static final int CHILD_PERCENT_CHANCE = 90; // 10%

    public Child(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public void say() {
        System.out.println("Crying...");
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) throws IOException {

        final int randomPercent = rand.nextInt(MAX_PERCENT_CHANCE);

        if (randomPercent > CHILD_PERCENT_CHANCE) {
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            System.out.println("Moooooooooom!");
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }
}
