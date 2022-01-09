package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Home;
import house.Room;
import stuff.Auto;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.devices.factory.DeviceFactory;
import stuff.observe.PositronicBrain;
import stuff.state.RestingState;
import stuff.state.UsingState;

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

    @Override
    public void findActivity() {
        if (getToDoList().isEmpty()) {
            PositronicBrain positronicBrain = PositronicBrain.getInstance();
            useStuff(positronicBrain.adviceWhatToDoFor(this));
        } else {
            Random random = new Random();
            if (random.nextBoolean()) {
                System.out.println("NA SPORTIKE");
                doSport();
            } else {

                UsableObject currentStuff = getToDoList().poll();
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
                usableObject.setState(new UsingState(usableObject));
            }
        }
    }

    public void zratb() {
        System.out.println(this.getName() + " goes to zratb");
        DeviceFactory deviceFactory = DeviceFactory.getInstance();
        List<Device> devices = deviceFactory.getDevices();
        for (Device d : devices) {
            if (d.getType().equals(StuffType.FRIDGE)) {
                Fridge fridge = (Fridge) d;
                fridge.eating();
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

    public void refillFridge(Fridge fridge) {
        Auto auto = Home.getInstance().getAuto();
        this.moveTo(auto.getCurrentRoom());
        auto.goOutFromHome(this);
        moveTo(fridge.getCurrentRoom());
        fridge.refillingFeed();
        usingObject = fridge;
        System.out.println(this.getName() + " is going to refill the " + fridge.getType());
    }
}
