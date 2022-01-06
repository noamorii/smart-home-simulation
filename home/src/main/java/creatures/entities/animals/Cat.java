package creatures.entities.animals;

import creatures.CreaturesType;
import house.Room;

public class Cat extends Pet {

    public Cat(String name, int age, String breed, CreaturesType type, Room room) {
        super(name, breed, age, type, room);
    }

    @Override
    public void say() {
        System.out.println("Meow");
    }
}

