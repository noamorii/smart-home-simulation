package creatures.entities.people;

import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

import java.util.Random;

public class Child extends Person {

    public Child(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    public void say() {
        System.out.println("Crying...");
    }

    @Override
    public void moveTo() {
    }

    @Override
    public void useStuff(Device device){
        Random rand = new Random();
        int upperbound = 11;
        int int_random = rand.nextInt(upperbound);
        if (int_random > 7) {
            brakeStuff(device);
        } else {
            device.usingDevice();
        }
    }

    @Override
    public void brakeStuff(Device device) {
        System.out.println("Moooooooooom!");
        device.breakingDevice();
    }

}
