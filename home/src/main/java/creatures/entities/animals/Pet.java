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

import java.util.Random;

public abstract class Pet implements Creature {

    private final Random rand = new Random();

    private final String name, breed;
    private final int age;
    private final CreaturesType type;
    private Room room;

    private int hungerLevel = 0;
    private int currentActionProgress = 1;
    private UsableObject usingObject = null;

    public Pet(String name, String breed, int age, CreaturesType type, Room room) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.room = room;
    }

    @Override
    public abstract void say();

    public void moveTo(Room room) {
        this.room = room;
    }

    @Override
    public boolean chanceBrakeStuff(UsableObject usableObject) {

        final int maxPercent = 100;
        final int randomPercent = rand.nextInt(maxPercent);

        if (randomPercent > 95) {
            System.out.println(this.getName() + " says: I broke " + usableObject.getType());
            usableObject.breakingDevice();
            return true;
        }
        return false;
    }

    @Override
    public void useStuff(UsableObject usableObject) {
        if (usableObject == null) System.out.println("waiting");
        System.out.println(this.getName() + " says: I am using " + usableObject.getType());
        moveTo(usableObject.getCurrentRoom());
        if (usableObject.getType() == StuffType.PET_FEEDER) {
            if (((PetFeeder) usableObject).isEmpty()) {
                usableObject.setState(new BrokenState(usableObject));
                System.out.println("Food in Pet Feeder is over");
                usableObject.notifyObserver();
                return;
            }
        }
        if (!chanceBrakeStuff(usableObject)) {
            usableObject.usingDevice();
            usingObject = usableObject;
        }
    }

    public void stopCurrentAction() {
        currentActionProgress = 1;
        getCurrentObject().setState(new RestingState(usingObject));
        usingObject = null;
    }

    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    public void increaseHungerLevel() {
        if (hungerLevel < 10) hungerLevel++;
    }

    public boolean isHungry() {
        return hungerLevel >= 8;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void resetHungerLevel() {
        hungerLevel = 0;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public CreaturesType getType() {
        return type;
    }

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

    @Override
    public void findActivity() {
        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        Device device = positronicBrain.adviceDeviceFor(this);
        useStuff(device);
    }

}

