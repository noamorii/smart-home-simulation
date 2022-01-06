package creatures.entities;

import stuff.devices.Device;

public interface Creature {

    void say();

    void moveTo();

    void brakeStuff(Device device);

    void useStuff(Device device);
}
