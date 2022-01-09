package creatures.entities.people;

import creatures.factories.CreaturesType;
import creatures.entities.Creature;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.devices.PetFeeder;
import stuff.devices.StuffType;
import stuff.observe.PositronicBrain;
import stuff.sport.Bike;
import stuff.sport.Sport;
import stuff.sport.factory.SportFactory;
import stuff.state.RestingState;

import java.util.List;

public abstract class Person implements Creature {

    private final String name;
    private final int age;
    private Room room;
    private final CreaturesType type;

    private int currentActionProgress = 0;

    public Person(String name, int age, Room room, CreaturesType type) {
        this.name = name;
        this.age = age;
        this.room = room;
        this.type = type;
    }

    @Override
    public abstract void say();

    public void moveTo(Room room) {
        this.room = room;
    }

    public int getCurrentActionProgress() {
        return currentActionProgress;
    }

    public void stopCurrentAction() {
        currentActionProgress = 0;
    }

    public void brakeStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
        usableObject.breakingDevice();
    }

    public void useStuff(UsableObject usableObject) {
        moveTo(usableObject.getCurrentRoom());
        usableObject.usingDevice();
        usableObject.setState(new RestingState(usableObject));
    }

    public void doSport() {
        Sport sport = PositronicBrain.getInstance().getRandomFreeSport();
        if (sport.getType().equals(StuffType.BIKE)) {
            ((Bike) sport).goOutFromHome(this);
        } else {
            System.out.println("I am going to sport on " + sport.getType());
            moveTo(sport.getCurrentRoom());
            sport.usingDevice();
            sport.setState(new RestingState(sport));
        }
    }

    public void refillPetFeeder(PetFeeder petFeeder) {
        moveTo(petFeeder.getCurrentRoom());
        System.out.println(this.name + " is going to refill Pet Feeder");
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
