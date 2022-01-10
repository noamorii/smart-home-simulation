package stuff.sport;

import house.Room;
import stuff.devices.StuffType;

public class Treadmill extends Sport {

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 6;
    private static final int IN_USING_ELECTRICITY = 4;

    /**
     * Instantiates a Treadmill.
     *
     * @param room          the location
     */
    public Treadmill(Room room) {
        super(USING_TICKS, room, StuffType.TREADMILL,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

}
