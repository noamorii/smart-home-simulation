package creatures.entities.people;

import creatures.CreaturesType;
import creatures.entities.Creature;

public class Child extends Creature {

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
    public void brakeStuff() {

    }

    public void repairStuff() {
    }

}
