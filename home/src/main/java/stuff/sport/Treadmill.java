package stuff.sport;

import house.Room;
import stuff.sport.factory.SportType;

public class Treadmill extends Sport{

    private static final int USING_TICKS = 4;

    public Treadmill(Room room) {
        super(USING_TICKS, room, SportType.TREADMILL);
    }
}
