package creatures.entities.animals;

import creatures.factories.CreaturesType;
import house.Room;

public class Parrot extends Pet {

    public Parrot(String name, int age, String breed, CreaturesType type, Room room) {
        super(name, breed, age, type, room);
    }

    public void say() {
        System.out.println("Tweet");
    }
}
