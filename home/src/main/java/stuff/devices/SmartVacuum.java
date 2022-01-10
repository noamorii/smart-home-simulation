package stuff.devices;

import house.Room;

public class SmartVacuum extends Device{

    private static final int USING_TICKS = 2;
    private static final int RESTING_ELECTRICITY = 2;
    private static final int BROKEN_ELECTRICITY = 5;
    private static final int IN_USING_ELECTRICITY = 0;

    /**
     *  The instance ot Smart Vacuum.
     *
     * @param room           the location
     */
    public SmartVacuum(Room room) {
        super(USING_TICKS, room, StuffType.VACUUM,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
