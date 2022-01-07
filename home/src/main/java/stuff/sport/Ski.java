package stuff.sport;

import house.Room;
import stuff.UsableObject;

public class Ski extends UsableObject {

    private static final int USING_TICKS = 4;

    protected Ski(Room room) {
        super(USING_TICKS, room);
    }
}
