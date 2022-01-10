package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;

/**
 * Class representing a child.
 */
public class Child extends Person {

    /**
     * Chance to break the device.
     */
    private static final int CHILD_PERCENT_CHANCE = 90; // 10%

    public Child(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    @Override
    public void say() {
        System.out.println("Crying...");
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {
        /*
         * Random chance to break the device.
         */
        final int randomPercent = rand.nextInt(MAX_PERCENT_CHANCE);

        if (randomPercent > CHILD_PERCENT_CHANCE) {
            usableObject.addEventToReport(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.addEventToReport("Moooooooooom!");
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }
}
