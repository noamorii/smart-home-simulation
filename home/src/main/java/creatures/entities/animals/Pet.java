package creatures.entities.animals;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.observe.PositronicBrain;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.io.IOException;
import java.util.Random;

public abstract class Pet implements Creature {

    private static final int PET_PERCENT_CHANCE = 95; // 5%

    private final String name, breed;
    private final int age;
    private final CreaturesType type;
    private Room room;

    private int hungerLevel = DEFAULT_HUNGRY_LEVEL;
    private int currentActionProgress = STARTING_ACTION_ITERATION;
    private UsableObject usingObject = null;

    public Pet(String name, String breed, int age, CreaturesType type, Room room) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.room = room;
    }

    @Override
    public void findActivity() throws IOException{
        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        Device device = positronicBrain.adviceDeviceFor(this);
        useStuff(device);
        increaseHungerLevel();
    }

    private boolean isEmptyPetFeeder(UsableObject usableObject) throws IOException{

        if (usableObject.getType() == StuffType.PET_FEEDER) {

            if (((PetFeeder) usableObject).isEmpty()) {
                usableObject.setState(new BrokenState(usableObject));
                System.out.println("Food in Pet Feeder is over");
                usableObject.notifyObserver();
                return true;
            }
            resetHungerLevel();
        } return false;
    }

    @Override
    public abstract void say();

    @Override
    public void moveTo(Room room) {
        this.room = room;
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) throws IOException {

        final int randomPercent = rand.nextInt(MAX_PERCENT_CHANCE);

        if (randomPercent > PET_PERCENT_CHANCE) {
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    @Override
    public void useStuff(UsableObject usableObject) throws IOException {

        if (usableObject != null) {
            System.out.println(this.getName() + " says: I am using " + usableObject.getType());
            if (!isEmptyPetFeeder(usableObject) && !chanceBrakeStuff(usableObject)) {
                moveTo(usableObject.getCurrentRoom());
                usableObject.usingStuff();
                usingObject = usableObject;
                return;
            }
        } waiting();
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

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

}

