package stuff.sport;

import house.Room;
import stuff.devices.StuffType;

public class Stepper extends Sport {

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 5;

    /**
     * Instantiates a Stepper.
     *
     * @param room          the location
     */
    public Stepper(Room room) {
        super(USING_TICKS, room, StuffType.STEPPER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
