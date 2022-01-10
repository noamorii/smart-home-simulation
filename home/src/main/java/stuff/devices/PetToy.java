package stuff.devices;

import house.Room;

import java.io.IOException;

public class PetToy extends Device {

    private static final int USING_TICKS = 6;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 0;
    private static final int IN_USING_ELECTRICITY = 2;

    /**
     * The instance ot Pet Toy.
     *
     * @param room the location
     */
    public PetToy(Room room) throws IOException {
        super(USING_TICKS, room, StuffType.PET_TOY,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }
}
