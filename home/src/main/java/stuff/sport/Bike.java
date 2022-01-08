package stuff.sport;

import house.Room;
import stuff.devices.StuffType;

public class Bike extends Sport {

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 6;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 0;

    public Bike(Room room) {
        super(USING_TICKS, room, StuffType.STEPPER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
