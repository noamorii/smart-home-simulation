package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.observe.PositronicBrain;
import stuff.state.RestingState;

import java.util.*;

public class Adult extends Person {

    private static Queue<Device> toDoList = new LinkedList<>();

    public Adult(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public static Queue<Device> getToDoList() {
        return toDoList;
    }

    public static void setToDoList(Queue<Device> toDoList) {
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
            Device currentDevice = getToDoList().poll(); //todo sport
            switch (currentDevice.getType()) {
                case FRIDGE:
                    if (((Fridge) currentDevice).isEmpty()) {
                        refillFridge((Fridge) currentDevice);
                    } else {
                        repairStuff(currentDevice);
                    }
                    break;
                case PET_FEEDER:
                    if (((PetFeeder) currentDevice).isEmpty()) {
                        refillPetFeeder((PetFeeder) currentDevice);
                    } else {
                        repairStuff(currentDevice);
                    }
                    break;
                default:
                    repairStuff(currentDevice);
            }
        }
    }

    @Override
    public void useStuff(Device device) {
        if (device == null) {
            System.out.println("Pizda");
        } else {
            moveTo(device.getCurrentRoom());
            Random rand = new Random();
            int upperbound = 100;
            int int_random = rand.nextInt(upperbound);
            if (int_random > 90) {
                brakeStuff(device);
            } else {
                System.out.println(this.getName() + " says: I am using " + device.getType());
                device.usingDevice();
                device.setState(new RestingState(device));
            }
        }
    }

    @Override
    public void brakeStuff(Device device) {
        moveTo(device.getCurrentRoom());
        System.out.println(this.getName() + " says: I broke " + device.getType());
        device.breakingDevice();
    }

    public void repairStuff(Device device) {
        moveTo(device.getCurrentRoom());
        System.out.println(this.getName() + " is going to repair the " + device.getType());
        device.fixingDevice();
        device.setState(new RestingState(device));
    }

    public void refillFridge(Fridge fridge) {
        moveTo(fridge.getCurrentRoom());
        System.out.println(this.getName() + " is going to refill the " + fridge.getType());
    }
}
