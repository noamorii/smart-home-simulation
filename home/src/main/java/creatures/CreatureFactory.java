package creatures;

import creatures.entities.Creature;
import creatures.entities.animals.Cat;
import creatures.entities.animals.Parrot;
import creatures.entities.people.Adult;
import creatures.entities.people.Child;

public class CreatureFactory {

    public Creature createCreature(CreaturesType type, String creatureName, int creatureAge) {
        return switch (type) {
            case ADULT -> new Adult(creatureName, creatureAge, type);
            case CHILD -> new Child(creatureName, creatureAge, type);
            case PARROT -> new Parrot(creatureName, creatureAge, type);
            case CAT -> new Cat(creatureName, creatureAge, type);
            default -> throw new RuntimeException(type + " not found");
        };
    }
}
