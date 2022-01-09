package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Home;
import house.Room;
import stuff.Auto;
import stuff.UsableObject;
import stuff.devices.*;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Adult extends Person {

    private static final int ADULT_PERCENT_CHANCE = 95; // 5%

    private static final Queue<UsableObject> toDoList = new LinkedList<>();

    public Adult(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void findActivity() {

        if (!getToDoList().isEmpty()) { //check if toDoList is empty
            doTasks();
        } else {
            super.findActivity();
        }
    }

    public void doTasks() {

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
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    public void repairStuff(UsableObject usableObject) {
        System.out.println(this.getName() + " is going to repair the " + usableObject.getType());
        Manual manual = usableObject.getManual();
        manual.readManual();
        usingObject = usableObject;
        usableObject.fixingDevice();
    }

    public void refill(FoodContainer container) {
        Auto auto = Home.getInstance().getAuto();

        this.moveTo(auto.getCurrentRoom());
        auto.goOutFromHome(this);

        auto.comeBackHome(this);
        moveTo(container.getCurrentRoom());

        container.refill();
        usingObject = (UsableObject) container;
        System.out.println(this.getName() + " is going to refill the " + container.getType());
    }

    public static Queue<UsableObject> getToDoList() {
        return toDoList;
    }

    public static void addTask(UsableObject object) {
        toDoList.add(object);
    }
}