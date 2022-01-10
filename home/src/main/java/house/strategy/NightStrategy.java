package house.strategy;

import creatures.entities.animals.Pet;
import creatures.entities.people.Person;

public class NightStrategy implements Strategy {

    @Override
    public void findActivity(Person person) {
        System.out.println("Sleeping");
    }

    @Override
    public void findActivity(Pet pet) {
        System.out.println("Sleeping");
    }
}
