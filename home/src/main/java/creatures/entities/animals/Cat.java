package creatures.entities.animals;

import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

public class Cat extends Pet {

    public Cat(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    @Override
    public void say() {
        System.out.println("Meow");
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

