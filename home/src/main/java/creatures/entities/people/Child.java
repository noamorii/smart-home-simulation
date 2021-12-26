package creatures.entities.people;

import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

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
    public void brakeStuff(Device device) {

    }

    @Override
    public void useStuff(Device device){
        device.usingDevice();
    }

}
