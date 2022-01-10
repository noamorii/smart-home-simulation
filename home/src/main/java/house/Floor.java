package house;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int level;
    private final List<Room> rooms = new ArrayList<>();

    /**
     * Instantiates a new Floor.
     *
     * @param level        level of the floor
     */
    public Floor(int level) {
        this.level = level;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getLevel() {
        return level;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
