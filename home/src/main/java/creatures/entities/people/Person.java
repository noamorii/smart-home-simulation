package creatures.entities.people;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.observe.PositronicBrain;
import stuff.sport.Bike;
import stuff.sport.Sport;
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

    public void brakeStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
        usableObject.breakingDevice();
    }

    public void useStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
        usingObject = usableObject;
        usableObject.usingDevice();
        //usableObject.setState(new RestingState(usableObject));
    }

    public void doSport() {
        System.out.println("NA SPORTIKE");
        Sport sport = PositronicBrain.getInstance().getRandomFreeSport();
        if (sport.getType().equals(StuffType.BIKE)) {
            ((Bike) sport).goOutFromHome(this);
        } else {
            System.out.println("I am going to sport on " + sport.getType());
            moveTo(sport.getCurrentRoom());
            sport.usingDevice();
            usingObject = sport;
            //sport.setState(new RestingState(sport));
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
    public abstract void findActivity();

    @Override
    public CreaturesType getMainCreatureType() {
        return CreaturesType.PERSON;
    }

    public CreaturesType getType() {
        return type;
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
