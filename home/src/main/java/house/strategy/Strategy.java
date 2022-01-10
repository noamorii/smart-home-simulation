package house.strategy;

import creatures.entities.animals.Pet;
import creatures.entities.people.Person;

public interface Strategy {

    void findActivity(Person person);

    void findActivity(Pet pet);
}
