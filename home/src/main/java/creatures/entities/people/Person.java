package creatures.entities.people;

import creatures.factories.CreaturesType;
import creatures.entities.Creature;
import house.Room;
import stuff.devices.Device;
import stuff.devices.PetFeeder;
import stuff.sport.Sport;

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

    public void brakeStuff(Device device) {
        moveTo(device.getCurrentRoom());
        device.breakingDevice();
    }

    public void useStuff(Device device) {
        moveTo(device.getCurrentRoom());
        device.usingDevice();
    }

//    public void doSport(Sport sport) {
//        System.out.println("I am going to sport on " + sport.getName);
//        moveTo(sport.getCurrentRoom());
//        sport.usingDevice();
//    }

    public void refillPetFeeder(PetFeeder petFeeder){
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

    public Room getRoom() {
        return room;
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
