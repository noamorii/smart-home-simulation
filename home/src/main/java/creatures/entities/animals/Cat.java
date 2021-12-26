package creatures.entities.animals;

import creatures.CreaturesType;
import creatures.entities.Creature;

public class Cat extends Creature {

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
    public void brakeStuff() {

    }
}
