package creatures.entities.animals;

import creatures.factories.CreaturesType;
import house.Room;

/**
 * Class representing a parrot.
 */
public class Parrot extends Pet {

    public Parrot(String name, int age, String breed, CreaturesType type, Room room) {
        super(name, breed, age, type, room);
    }

    @Override
    public void say() {
        System.out.println("Tweet");
    }
}
