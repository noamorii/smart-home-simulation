package creatures.entities.people;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.observe.PositronicBrain;
import stuff.sport.Bike;
import stuff.sport.Sport;
import stuff.state.BrokenState;
import stuff.state.RestingState;

import java.util.Random;

public abstract class Person implements Creature {

    private final String name;
    private final int age;
    private Room room;
    private final CreaturesType type;

    private int currentActionProgress = 1;
    protected UsableObject usingObject = null;

    public Person(String name, int age, Room room, CreaturesType type) {
        this.name = name;
        this.age = age;
        this.room = room;
        this.type = type;
    }

    public void setUsingObject(UsableObject usingObject) {
        this.usingObject = usingObject;
    }

    @Override
    public abstract void say();

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

    public abstract boolean chanceBrakeStuff(UsableObject usableObject);

    public void useStuff(UsableObject usableObject) {

        if (usableObject == null) System.out.println("waiting");
        System.out.println(this.getName() + " says: I am using " + usableObject.getType());
        moveTo(usableObject.getCurrentRoom());
        if (usableObject.getType() == StuffType.FRIDGE) {
            if (((Fridge) usableObject).isEmpty()) {
                usableObject.setState(new BrokenState(usableObject));
                System.out.println("Food in Pet Feeder is over");
                usableObject.notifyObserver();
                return;
            }
        }
        if (!chanceBrakeStuff(usableObject)) {
            usingObject = usableObject;
            usableObject.usingDevice();
        }
    }

    public boolean flipCoin() {
        return (new Random()).nextBoolean();
    }

    public void refillPetFeeder(PetFeeder petFeeder){
        moveTo(petFeeder.getCurrentRoom());
        System.out.println(this.name + " is going to refill Pet Feeder");
        usingObject = petFeeder;
        petFeeder.refill();
    }

    public void findActivity() {

        UsableObject stuff;
        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        boolean doSport = flipCoin(); //choose sport or devices

        if (!doSport) {
            stuff = positronicBrain.adviceDeviceFor(this); // ask smart home for free device

        } else {

            stuff = PositronicBrain.getInstance().getRandomFreeSport();

//            if (stuff.getType().equals(StuffType.BIKE)) {
//                ((Bike) stuff).goOutFromHome(this);
//                return;
//            } //todo

        }
        useStuff(stuff);
    }

    @Override
    public CreaturesType getMainCreatureType() {
        return CreaturesType.PERSON;
    }

    public CreaturesType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

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
