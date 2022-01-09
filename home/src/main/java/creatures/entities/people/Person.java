package creatures.entities.people;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Fridge;
import stuff.devices.StuffType;
import stuff.observe.PositronicBrain;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.io.IOException;
import java.util.Random;

public abstract class Person implements Creature {

    private final String name;
    private final int age;
    private Room room;
    private final CreaturesType type;

    private int hungerLevel = DEFAULT_HUNGRY_LEVEL;

    private int currentActionProgress = 1;
    protected UsableObject usingObject = null;

    public Person(String name, int age, Room room, CreaturesType type) {
        this.name = name;
        this.age = age;
        this.room = room;
        this.type = type;
    }

    @Override
    public abstract void say();

    @Override
    public abstract boolean chanceBrakeStuff(UsableObject usableObject) throws IOException;

    public boolean flipCoin() {
        return (new Random()).nextBoolean();
    }

    @Override
    public void waiting() {
        System.out.println("Person: " + name + " is waiting for now");
    }

    public void findActivity() throws IOException {

        UsableObject stuff;

        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        boolean doSport = flipCoin(); //choose sport or devices

        if (!doSport) {
            stuff = positronicBrain.adviceDeviceFor(this); // ask smart home for free device
        } else {
            stuff = PositronicBrain.getInstance().getRandomFreeSport(); // ask smart home for free sport staff
        }
        useStuff(stuff);
    }

    public void useStuff(UsableObject usableObject) throws IOException {

        if (usableObject != null) {
            System.out.println(this.getName() + " says: I am using " + usableObject.getType());
            moveTo(usableObject.getCurrentRoom());

            if (usableObject.getType() == StuffType.FRIDGE) {
                if (((Fridge) usableObject).isEmpty()) {
                    usableObject.setState(new BrokenState(usableObject));
                    System.out.println("Food in Pet Feeder is over");
                    usableObject.notifyObserver();
                    return;
                }
                resetHungerLevel();
            }
            if (!chanceBrakeStuff(usableObject)) {
                usingObject = usableObject;
                usableObject.usingStuff();
            } return;
        } waiting();
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

    public void moveTo(Room room) {
        this.room = room;
    }

    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    public void increaseProgress() {
        currentActionProgress++;
    }

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

    public Room getCurrentRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", room=" + room.getName() +
                ", type=" + type +
                '}';
    }
}
