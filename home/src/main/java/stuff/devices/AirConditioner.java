package stuff.devices;

import house.Room;

public class AirConditioner extends Device{

    private static final int USING_TICKS = 3;
    private static final int RESTING_ELECTRICITY = 3;
    private static final int BROKEN_ELECTRICITY = 3;
    private static final int IN_USING_ELECTRICITY = 3;

    /**
     *  The instance ot Air Conditioner.
     *
     * @param room           the location
     */
    public AirConditioner(Room room) {
        super(USING_TICKS, room, StuffType.CONDITIONER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
