package creatures.factories;

import creatures.entities.people.Adult;
import creatures.entities.people.Child;
import creatures.entities.people.Person;
import house.Room;

import java.util.ArrayList;
import java.util.List;

public class PeopleFactory {

    /**
     * List of all persons
     */
    private final List<Person> people = new ArrayList<>();

    /**
     *  Factory method that creates people and adds it to the list.
     *
     * @param type           person's type
     * @param name           person's name
     * @param age            person's age
     * @param room           person's room
     * @return person
     */
    public Person create(CreaturesType type, String name, int age, Room room) throws Exception {
        Person person = switch (type) {
            case ADULT -> new Adult(name, age, room, type);
            case CHILD -> new Child(name, age, room, type);
            default -> throw new Exception(type + " not found");
        };
        people.add(person);
        return person;
    }

    /**
     * Returns list of all persons.
     * @return List<Person>
     */
    public List<Person> getPeople() {
        return people;
    }
}
