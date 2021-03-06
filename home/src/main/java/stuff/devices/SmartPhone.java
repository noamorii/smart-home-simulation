package stuff.devices;

import house.Room;

import java.io.IOException;

public class SmartPhone extends Device {

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 2;
    private static final int BROKEN_ELECTRICITY = 0;
    private static final int IN_USING_ELECTRICITY = 0;

    /**
     * The instance ot Smart Phone.
     *
     * @param room the location
     */
    public SmartPhone(Room room) throws IOException {
        super(USING_TICKS, room, StuffType.PHONE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
