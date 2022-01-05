package creatures.entities.people;

import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

public abstract class Person extends Creature {

    public Person(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    @Override
    public void say() {

    }

    @Override
    public void moveTo() {

    }

    @Override
    public void brakeStuff(Device device) {
        device.breakingDevice();
    }

    @Override
    public void useStuff(Device device) {
        device.usingDevice();
    }
}
