package stuff.sport;

import house.Room;
import stuff.sport.factory.SportType;

public class Orbitrek extends Sport{

    private static final int USING_TICKS = 4;

    public Orbitrek(Room room) {
        super(USING_TICKS, room, SportType.ORBITREK);
    }
}
