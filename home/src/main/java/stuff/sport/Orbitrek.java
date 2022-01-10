package stuff.sport;

import house.Room;
import stuff.devices.StuffType;

public class Orbitrek extends Sport{

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 5;

    /**
     * Instantiates a Orbitrek.
     *
     * @param room          the location
     */
    public Orbitrek(Room room) {
        super(USING_TICKS, room, StuffType.ORBITREK,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
