package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class Computer extends Device{

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 3;
    private static final int BROKEN_ELECTRICITY = 12;
    private static final int IN_USING_ELECTRICITY = 10;

    public Computer(Room room) {
        super(room, DeviceType.COMPUTER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY,  IN_USING_ELECTRICITY, USING_TICKS);
    }
}
