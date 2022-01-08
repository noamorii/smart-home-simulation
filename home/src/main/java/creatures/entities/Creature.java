package creatures.entities;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.devices.Device;

public interface Creature {

    void say();

    void moveTo(Room room);

    void brakeStuff(Device device);

    void useStuff(Device device);

    CreaturesType getType();

    Room getCurrentRoom();

    CreaturesType getMainCreatureType();
}
