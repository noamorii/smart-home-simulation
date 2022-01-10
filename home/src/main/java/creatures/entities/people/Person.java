package creatures.entities.people;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import house.strategy.Strategy;
import stuff.UsableObject;
import stuff.devices.Fridge;
import stuff.devices.StuffType;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.io.IOException;
import java.util.Random;

/**
 * Class representing a person.
 */
public abstract class Person implements Creature {

    private final String name;
    private final int age;
    private Room room;
    private final CreaturesType type;

    private Strategy strategy;

    private int hungerLevel = DEFAULT_HUNGRY_LEVEL;

    private int currentActionProgress = 1;
    protected UsableObject usingObject = null;

    /**
     * Instantiates a new Person.
     *
     * @param name person's name
     * @param age  person's age
     * @param room person's location
     * @param type person's type
     */
    public Person(String name, int age, Room room, CreaturesType type) {
        this.name = name;
        this.age = age;
        this.room = room;
        this.type = type;
    }

    @Override
    public abstract void say();

    @Override
    public abstract boolean chanceBrakeStuff(UsableObject usableObject);

    /**
     * A method that helps a person choose what to do: sports or use devices.
     *
     * @return boolean
     */
    public boolean flipCoin() {
        return (new Random()).nextBoolean();
    }

    @Override
    public void waiting() {
        System.out.println("Person: " + name + " is waiting for now");
    }

    @Override
    public void findActivity() throws IOException {
        strategy.findActivity(this);
    }

    @Override
    public void useStuff(UsableObject usableObject) {

        if (usableObject != null) {
            System.out.println(this.getName() + " says: I am using " + usableObject.getType());
            moveTo(usableObject.getCurrentRoom());

            if (usableObject.getType() == StuffType.FRIDGE) {
                if (((Fridge) usableObject).isEmpty()) {
                    usableObject.setState(new BrokenState(usableObject));
                    usableObject.addEventToReport("Food in Pet Feeder is over");
                    usableObject.notifyObserver();
                    return;
                }
                resetHungerLevel();
            }
            if (!chanceBrakeStuff(usableObject)) {
                usingObject = usableObject;
                usableObject.usingStuff();
            }
            return;
        }
        waiting();
    }

    public void setUsingObject(UsableObject usingObject) {
        this.usingObject = usingObject;
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
    public UsableObject getCurrentObject() {
        return usingObject;
    }

    @Override
    public void moveTo(Room room) {
        this.room = room;
    }

    @Override
    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    @Override
    public void increaseProgress() {
        currentActionProgress++;
    }

    @Override
    public void stopCurrentAction() {
        currentActionProgress = 1;
        getCurrentObject().setState(new RestingState(usingObject));
        usingObject = null;
    }

    @Override
    public CreaturesType getMainCreatureType() {
        return CreaturesType.PERSON;
    }

    @Override
    public CreaturesType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Room getCurrentRoom() {
        return room;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
