package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Home;
import house.Room;
import stuff.Auto;
import stuff.UsableObject;
import stuff.devices.FoodContainer;
import stuff.devices.Manual;
import stuff.devices.StuffType;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Class representing an adult person.
 */
public class Adult extends Person {

    /**
     * Chance to break the device.
     */
    private static final int ADULT_PERCENT_CHANCE = 95; // 5%

    private static final Queue<UsableObject> toDoList = new LinkedList<>();

    public Adult(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void findActivity() throws IOException {

        if (!getToDoList().isEmpty()) { //check if toDoList is empty
            doTasks();
        } else {
            super.findActivity();
        }
    }

    /**
     * Activities that an adult should do first.
     */
    private void doTasks() throws IOException {
        UsableObject currentStuff = getToDoList().poll();//take first element (not remove)
        Objects.requireNonNull(currentStuff);
        moveTo(currentStuff.getCurrentRoom());

        if (currentStuff.getType() == StuffType.FRIDGE ||
                currentStuff.getType() == StuffType.PET_FEEDER) {

            FoodContainer container =
                    (FoodContainer) currentStuff.getClass().cast(currentStuff);

            if (container.isEmpty()) {
                refill(container);
            }
        }
        repairStuff(currentStuff);
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {

        final int randomPercent = rand.nextInt(MAX_PERCENT_CHANCE);

        if (randomPercent > ADULT_PERCENT_CHANCE) {
            usableObject.addEventToReport(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    /**
     * Repairing of the devices and sport inventory.
     *
     * @param usableObject an object that an adult will fix
     */
    private void repairStuff(UsableObject usableObject) throws IOException {
        usableObject.addEventToReport(this.getName() + " is going to repair the " + usableObject.getType());
        Manual manual = usableObject.getManual();
        manual.readManual();
        usingObject = usableObject;
        usableObject.fixingDevice();
    }

    /**
     * Replenishment of food supplies.
     *
     * @param container container in which food is replenished
     */
    private void refill(FoodContainer container) throws IOException {
        Auto auto = Home.getInstance().getAuto();

        this.moveTo(auto.getCurrentRoom());
        auto.goOutFromHome(this);

        auto.comeBackHome(this);
        moveTo(container.getCurrentRoom());

        container.refill();
        usingObject = (UsableObject) container;
        usingObject.addEventToReport(this.getName() + " is going to refill the " + container.getType());
    }

    /**
     * Returns the queue of objects to deal with first
     *
     * @return Queue of UsableObject
     */
    public static Queue<UsableObject> getToDoList() {
        return toDoList;
    }

    /**
     * Adding an object to your to-do list.
     *
     * @param object object to add to your to-do list
     */
    public static void addTask(UsableObject object) {
        toDoList.add(object);
    }
}