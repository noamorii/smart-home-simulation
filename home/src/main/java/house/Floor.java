package house;

import java.util.List;

public class Floor {

    private final int level;
    private final List<Room> rooms;

    /**
     * Instantiates a new Floor.
     *
     * @param level        level of the floor
     * @param rooms        list of rooms on the floor
     */
    public Floor(int level, List<Room> rooms) {
        this.level = level;
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getLevel() {
        return level;
    }
}
