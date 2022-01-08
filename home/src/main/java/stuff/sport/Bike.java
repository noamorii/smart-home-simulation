package stuff.sport;

import house.Room;
import stuff.sport.factory.SportType;

public class Bike extends Sport {

    private static final int USING_TICKS = 4;

    public Bike(Room room) {
        super(USING_TICKS, room, SportType.BIKE);
    }


}
