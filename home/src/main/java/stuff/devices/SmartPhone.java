package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class SmartPhone extends Device{

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 2;
    private static final int BROKEN_ELECTRICITY = 0;
    private static final int IN_USING_ELECTRICITY = 0;

    public SmartPhone(Room room) {
        super(room, DeviceType.PHONE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY, USING_TICKS);
    }
}
