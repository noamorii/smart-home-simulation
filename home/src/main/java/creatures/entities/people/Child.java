package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import java.util.Random;

public class Child extends Person {

    private final Random rand = new Random();

    public Child(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public void say() {
        System.out.println("Crying...");
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {

        final int maxPercent = 100;
        final int randomPercent = rand.nextInt(maxPercent);

        if (randomPercent > 90) {
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            System.out.println("Moooooooooom!");
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }
}
