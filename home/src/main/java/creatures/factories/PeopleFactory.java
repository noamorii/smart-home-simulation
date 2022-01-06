package creatures.factories;

import creatures.entities.people.Adult;
import creatures.entities.people.Child;
import creatures.entities.people.Person;
import house.Room;

import java.util.ArrayList;
import java.util.List;

public class PeopleFactory {

    private List<Person> people = new ArrayList<>();

    public Person create(CreaturesType type, String name, int age, Room room) throws Exception {
        Person person = switch (type) {
            case ADULT -> new Adult(name, age, room, type);
            case CHILD -> new Child(name, age, room, type);
            default -> throw new Exception(type + " not found");
        };
        people.add(person);
        return person;
    }

    public List<Person> getPeople() {
        return people;
    }
}
