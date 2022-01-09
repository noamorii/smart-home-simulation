package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Home;
import house.Room;
import stuff.Auto;
import stuff.UsableObject;
import stuff.devices.*;

import stuff.observe.PositronicBrain;
import stuff.state.UsingState;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;

public class Adult extends Person {

    private final Random rand = new Random();

    private static Queue<UsableObject> toDoList = new LinkedList<>();

    public Adult(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public static Queue<UsableObject> getToDoList() {
        return toDoList;
    }

    public static void setToDoList(Queue<UsableObject> toDoList) {
        Adult.toDoList = toDoList;
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
                refillFridge(container);
                //container.refill();
            }
        }
        repairStuff(currentStuff);
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {

        final int maxPercent = 100;
        final int randomPercent = rand.nextInt(maxPercent);

        if (randomPercent > 95) {
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    public void repairStuff(UsableObject usableObject) {
        System.out.println(this.getName() + " is going to repair the " + usableObject.getType());
        usingObject = usableObject;
        usableObject.fixingDevice();
    }

    public void refillFridge(FoodContainer container) {
        Auto auto = Home.getInstance().getAuto();
        this.moveTo(auto.getCurrentRoom());
        auto.goOutFromHome(this);
        moveTo(container.getCurrentRoom());
        container.refill();
        usingObject = (UsableObject) container;
        System.out.println(this.getName() + " is going to refill the " + container.getType());
    }
}