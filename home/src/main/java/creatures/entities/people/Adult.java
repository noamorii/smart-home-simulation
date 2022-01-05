package creatures.entities.people;
import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

import java.util.Random;

public class Adult extends Person {

    public Adult(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void moveTo() {
    }

    public void repairStuff(Device device) {
        device.breakingDevice();
    }

    @Override
    public void useStuff(Device device){
        Random rand = new Random();
        int upperbound = 100;
        int int_random = rand.nextInt(upperbound);
        if (int_random > 90) {
            brakeStuff(device);
        } else {
            device.usingDevice();
        }
    }

    @Override
    public void brakeStuff(Device device) {
        System.out.println("Kurva!");
        device.breakingDevice();
    }
}
