package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.observe.PositronicBrain;
import stuff.state.RestingState;

import java.util.*;

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

    public void doToDo() {
        if (getToDoList().isEmpty()) {
            PositronicBrain positronicBrain = PositronicBrain.getInstance();
            useStuff(positronicBrain.adviceWhatToDoFor(this));
        }else {
            UsableObject currentStuff = getToDoList().poll(); //todo sport
            switch (currentStuff.getType()) {
                case FRIDGE:
                    if (((Fridge) currentStuff).isEmpty()) {
                        refillFridge((Fridge) currentStuff);
                    } else {
                        repairStuff(currentStuff);
                    }
                    break;
                case PET_FEEDER:
                    if (((PetFeeder) currentStuff).isEmpty()) {
                        refillPetFeeder((PetFeeder) currentStuff);
                    } else {
                        repairStuff(currentStuff);
                    }
                    break;
                default:
                    repairStuff(currentStuff);
            }
        }
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
                usableObject.usingDevice();
                usableObject.setState(new RestingState(usableObject));
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
        usableObject.fixingDevice();
        usableObject.setState(new RestingState(usableObject));
    }

    public void refillFridge(Fridge fridge) {
        moveTo(fridge.getCurrentRoom());
        System.out.println(this.getName() + " is going to refill the " + fridge.getType());
    }
}
