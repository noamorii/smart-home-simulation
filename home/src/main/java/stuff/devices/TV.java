package stuff.devices;

import house.Room;

public class TV extends Device{

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 10;
    private static final int IN_USING_ELECTRICITY = 8;

    /**
     *  The instance ot TV.
     *
     * @param room           the location
     */
    public TV(Room room) {
        super(USING_TICKS, room, StuffType.TV,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
