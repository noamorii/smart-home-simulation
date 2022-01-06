package creatures.entities;

import house.Room;
import stuff.devices.Device;

public interface Creature {

    void say();

    void moveTo(Room room);

    void brakeStuff(Device device);

    void useStuff(Device device);
}
