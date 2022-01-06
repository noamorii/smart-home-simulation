package creatures.entities.people;

import creatures.factories.CreaturesType;
import creatures.entities.Creature;
import house.Room;
import stuff.devices.Device;

public abstract class Person implements Creature {

    private final String name;
    private final int age;
    private Room room;
    private final CreaturesType type;

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
        device.breakingDevice();
    }

    public void useStuff(Device device) {
        device.usingDevice();
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
}
