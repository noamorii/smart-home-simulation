package creatures.entities.animals;

import creatures.CreaturesType;
import creatures.entities.Creature;
import house.Room;
import stuff.devices.Device;

public abstract class Pet implements Creature {

    private final String nickname, breed;
    private final int age;
    private final CreaturesType type;
    private Room room;

    public Pet(String nickname, String breed, int age, CreaturesType type, Room room) {
        this.nickname = nickname;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.room = room;
    }

    public void moveTo() {

    }

    public void brakeStuff(Device device) {

    }

    public void useStuff(Device device) {
    }

    public String getNickname() {
        return nickname;
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

    public Room getRoom() {
        return room;
    }
}

