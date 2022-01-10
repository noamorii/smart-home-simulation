package stuff.devices;

import house.Room;

import java.io.IOException;

public class Computer extends Device {

    private static final int USING_TICKS = 5;
    private static final int RESTING_ELECTRICITY = 3;
    private static final int BROKEN_ELECTRICITY = 12;
    private static final int IN_USING_ELECTRICITY = 10;

    /**
     * The instance ot Computer.
     *
     * @param room the location
     */
    public Computer(Room room) throws IOException {
        super(USING_TICKS, room, StuffType.COMPUTER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
