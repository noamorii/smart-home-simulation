package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class SmartVacuum extends Device{

    private static final int USING_TICKS = 2;
    private static final int RESTING_ELECTRICITY = 2;
    private static final int BROKEN_ELECTRICITY = 5;
    private static final int IN_USING_ELECTRICITY = 0;

    public SmartVacuum(Room room) {
        super(room, DeviceType.VACUUM,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY,  IN_USING_ELECTRICITY, USING_TICKS);
    }
}
