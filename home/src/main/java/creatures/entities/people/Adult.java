package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.observe.PositronicBrain;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adult extends Person {

    private static List<Device> toDoList = new ArrayList<>();

    public Adult(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public static List<Device> getToDoList() {
        return toDoList;
    }

    public static void setToDoList(List<Device> toDoList) {
        Adult.toDoList = toDoList;
    }

    public void say() {
        System.out.println("Hello");
    }

    public void doToDo() {
        if (getToDoList().size() == 0) {
            PositronicBrain positronicBrain = PositronicBrain.getInstance();
            useStuff(positronicBrain.adviceWhatToDo());
        }else {
            Device currentDevice = getToDoList().get(0);
            switch (currentDevice.getName()) {
                case "Fridge":
                    if (((Fridge) currentDevice).isEmpty()) {
                        refillFridge((Fridge) currentDevice);
                    } else {
                        repairStuff(currentDevice);
                    }
                    break;
                case "Pet Feeder":
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
            moveTo(device.getRoom());
            Random rand = new Random();
            int upperbound = 100;
            int int_random = rand.nextInt(upperbound);
            if (int_random > 90) {
                brakeStuff(device);
            } else {
                device.usingDevice();
//            device.setState(new RestingState(device));
            }
        }
    }

    @Override
    public void brakeStuff(Device device) {
        moveTo(device.getRoom());
        System.out.println(this.getName() + " says: Kurva! I broke " + device.getName());
        device.breakingDevice();
    }

    public void repairStuff(Device device) {
        moveTo(device.getRoom());
        System.out.println(this.getName() + " is going to repair the " + device.getName());
        device.fixingDevice();
        device.setState(new RestingState(device));
    }

    public void refillFridge(Fridge fridge) {
        moveTo(fridge.getRoom());
        System.out.println(this.getName() + " is going to refill the " + fridge.getName());
    }
}
