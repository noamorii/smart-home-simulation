package creatures.factories;

import creatures.entities.animals.Cat;
import creatures.entities.animals.Parrot;
import creatures.entities.animals.Pet;
import house.Room;

import java.util.ArrayList;
import java.util.List;

public class PetFactory {

    /**
     * List of all pets
     */
    private final List<Pet> pets = new ArrayList<>();

    /**
     * Factory method that creates pets and adds it to the list.
     *
     * @param type              pet's type
     * @param petName           pet's name
     * @param petAge            pet's age
     * @param petBreed          pet's breed
     * @param room              pet's location
     * @return pet
     */
    public Pet create(CreaturesType type, String petName, int petAge, String petBreed, Room room) throws Exception {
        Pet pet = switch (type) {
            case PARROT -> new Parrot(petName, petAge, petBreed, type, room);
            case CAT -> new Cat(petName, petAge, petBreed, type, room);
            default -> throw new Exception(type + " not found");
        };
        pets.add(pet);
        return pet;
    }

    /**
     * Returns list of all persons.
     * @return List<Person>
     */
    public List<Pet> getPets() {
        return pets;
    }
}
