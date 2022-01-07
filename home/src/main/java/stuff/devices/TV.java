package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class TV extends Device{

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 10;
    private static final int IN_USING_ELECTRICITY = 8;

    public TV(Room room) {
        super(room, DeviceType.TV,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY,  IN_USING_ELECTRICITY, USING_TICKS);
    }
}
