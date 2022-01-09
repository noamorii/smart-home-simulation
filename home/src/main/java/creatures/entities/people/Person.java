package creatures.entities.people;

import creatures.factories.CreaturesType;
import creatures.entities.Creature;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.observe.PositronicBrain;
import stuff.sport.Sport;
import stuff.state.RestingState;

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
        usableObject.setState(new RestingState(usableObject));
    }

//    public void doSport(Sport sport) {
//        System.out.println("I am going to sport on " + sport.getName);
//        moveTo(sport.getCurrentRoom());
//        sport.usingDevice();
//    }



    public void refillPetFeeder(PetFeeder petFeeder){
        moveTo(petFeeder.getCurrentRoom());
        System.out.println(this.name + " is going to refill Pet Feeder");
        usingObject = petFeeder;
        petFeeder.refillingFeed();
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
