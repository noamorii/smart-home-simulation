package creatures.factories;

import creatures.entities.animals.Cat;
import creatures.entities.animals.Parrot;
import creatures.entities.animals.Pet;
import house.Room;

import java.util.ArrayList;
import java.util.List;

public class PetFactory {

    private final List<Pet> pets = new ArrayList<>();

    public Pet create(CreaturesType type, String petName, int petAge, String petBreed, Room room) throws Exception {
        Pet pet = switch (type) {
            case PARROT -> new Parrot(petName, petAge, petBreed, type, room);
            case CAT -> new Cat(petName, petAge, petBreed, type, room);
            default -> throw new Exception(type + " not found");
        };
        pets.add(pet);
        return pet;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
