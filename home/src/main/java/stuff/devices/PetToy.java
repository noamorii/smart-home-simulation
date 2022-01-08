package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class PetToy extends Device {

    private static final int USING_TICKS = 6;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 0;
    private static final int IN_USING_ELECTRICITY = 2;

    public PetToy(Room room) {
        super(room, DeviceType.PET_TOY,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY,  IN_USING_ELECTRICITY, USING_TICKS);
    }
}
