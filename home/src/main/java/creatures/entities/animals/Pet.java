package creatures.entities.animals;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import house.strategy.Strategy;
import stuff.UsableObject;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.io.IOException;

/**
 * Class representing a pet.
 */
public abstract class Pet implements Creature {

    private static final int PET_PERCENT_CHANCE = 95; // 5%

    private final String name, breed;
    private final int age;
    private final CreaturesType type;
    private Strategy strategy;
    private Room room;

    private int hungerLevel = DEFAULT_HUNGRY_LEVEL;
    private int currentActionProgress = STARTING_ACTION_ITERATION;
    private UsableObject usingObject = null;

    /**
     * Instantiates a new Pet.
     *
     * @param name  pet's name
     * @param breed pet's breed
     * @param age   pet's age
     * @param type  pet's type
     * @param room  pet's location
     */
    public Pet(String name, String breed, int age, CreaturesType type, Room room) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.room = room;
    }

    @Override
    public void findActivity() throws IOException {
        strategy.findActivity(this);
    }

    /**
     * Checks if the Pet Feeder is empty.
     *
     * @param usableObject Pet Feeder
     * @return boolean
     */
    private boolean isEmptyPetFeeder(UsableObject usableObject) {
        if (usableObject.getType() == StuffType.PET_FEEDER) {

            if (((PetFeeder) usableObject).isEmpty()) {
                usableObject.setState(new BrokenState(usableObject));
                usableObject.addEventToReport("Food in Pet Feeder is over");
                usableObject.notifyObserver();
                return true;
            }
            resetHungerLevel();
        }
        return false;
    }

    @Override
    public abstract void say();

    @Override
    public void moveTo(Room room) {
        this.room = room;
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {
        /*
         * Random chance to break the device.
         */
        final int randomPercent = rand.nextInt(MAX_PERCENT_CHANCE);

        if (randomPercent > PET_PERCENT_CHANCE) {
            usableObject.addEventToReport(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    @Override
    public void useStuff(UsableObject usableObject) {

        if (usableObject != null) {
            System.out.println(this.getName() + " says: I am using " + usableObject.getType());
            if (!isEmptyPetFeeder(usableObject) && !chanceBrakeStuff(usableObject)) {
                moveTo(usableObject.getCurrentRoom());
                usableObject.usingStuff();
                usingObject = usableObject;
                return;
            }
        }
        waiting();
    }

    @Override
    public void stopCurrentAction() {
        currentActionProgress = 1;
        getCurrentObject().setState(new RestingState(usingObject));
        usingObject = null;
    }

    @Override
    public void waiting() {
        System.out.println("Pet " + this.name + " is waiting for now");
    }

    @Override
    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    @Override
    public void increaseHungerLevel() {
        if (hungerLevel < MAX_HUNGRY_LEVEL) hungerLevel++;
    }

    @Override
    public void resetHungerLevel() {
        hungerLevel = DEFAULT_HUNGRY_LEVEL;
    }

    @Override
    public CreaturesType getType() {
        return type;
    }

    @Override
    public Room getCurrentRoom() {
        return room;
    }

    @Override
    public UsableObject getCurrentObject() {
        return usingObject;
    }

    @Override
    public void increaseProgress() {
        currentActionProgress++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CreaturesType getMainCreatureType() {
        return CreaturesType.PET;
    }

    /**
     * Returns pet's breed.
     *
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

