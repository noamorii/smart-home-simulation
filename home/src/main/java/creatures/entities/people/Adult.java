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

        if (getToDoList().isEmpty()) { //check if toDoList is empty

            PositronicBrain positronicBrain = PositronicBrain.getInstance();
            boolean doSport = flipCoin(); //choose sport or devices

            if (!doSport) {
                Device device = positronicBrain.adviceDeviceFor(this); // ask smart home for free device
                useStuff(device);
                return;
            }
            doSport();
            return;
        }
        doTasks();
    }

    public void doTasks() {

        UsableObject currentStuff = getToDoList().poll();
        Objects.requireNonNull(currentStuff);



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
    public void useStuff(UsableObject usableObject) {
        if (usableObject == null) {
            System.out.println("Pizda");
        } else {
            moveTo(usableObject.getCurrentRoom());
            Random rand = new Random();
            int upperbound = 100;
            int int_random = rand.nextInt(upperbound);
            if (int_random > 90) {
                brakeStuff(usableObject);
            } else {
                System.out.println(this.getName() + " says: I am using " + usableObject.getType());
                usingObject = usableObject;
                usableObject.usingDevice();
            }
        }
    }

    @Override
    public void brakeStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
        System.out.println(this.getName() + " says: I broke " + usableObject.getType());
        usableObject.breakingDevice();
    }

    public void repairStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
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