package creatures.entities.animals;

import creatures.CreaturesType;
import stuff.devices.Device;

public class Parrot extends Pet {

    public Parrot(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    public void say() {
        System.out.println("Tweet");
    }

    @Override
    public void moveTo() {

    }

    @Override
    public void brakeStuff(Device device) {

    }

    @Override
    public void useStuff(Device device) {

    }


}
