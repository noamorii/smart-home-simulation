package creatures.entities.animals;

import creatures.CreaturesType;
import creatures.entities.Creature;

public class Parrot extends Creature {

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
    public void brakeStuff() {

    }
}
