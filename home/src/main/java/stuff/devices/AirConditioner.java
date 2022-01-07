package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class AirConditioner extends Device{

    private static final int USING_TICKS = 3;
    private static final int RESTING_ELECTRICITY = 3;
    private static final int BROKEN_ELECTRICITY = 3;
    private static final int IN_USING_ELECTRICITY = 3;

    public AirConditioner(Room room) {
        super(room, DeviceType.CONDITIONER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY, USING_TICKS);
    }
}
