package stuff.sport;

import house.Room;
import stuff.sport.factory.SportType;

public class Stepper extends Sport {

    private static final int USING_TICKS = 4;

    public Stepper(Room room) {
        super(USING_TICKS, room, SportType.STEPPER);
    }
}
