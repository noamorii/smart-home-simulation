package creatures.entities;

import creatures.CreaturesType;
import creatures.state.CreatureState;
import house.Room;
import stuff.devices.Device;

public abstract class Creature {

    final private int age;
    final private CreaturesType type;
    final private String name;
    private Room room;
    private CreatureState creaturesState;

    public Creature(String name, int age, CreaturesType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public abstract void say();
    public abstract void moveTo();
    public abstract void brakeStuff(Device device);
    public abstract void useStuff(Device device);

    public void useFeeder() {
        switch (type) {
            case ADULT, CHILD -> {
                System.out.println("refill");
            }
            case PARROT, CAT -> {
                System.out.println("Eat");
            }
        }
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCreaturesState(CreatureState creaturesState) {
        this.creaturesState = creaturesState;
    }

    public Room getRoom() {
        return room;
    }

    public int getAge() {
        return age;
    }

    public CreatureState getCreaturesState() {
        return creaturesState;
    }

    public CreaturesType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
