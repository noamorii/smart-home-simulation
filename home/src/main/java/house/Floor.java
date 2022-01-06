package house;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int level;
//    private final Home home;
    private List<Room> rooms = new ArrayList<>();

    public Floor(int level, List<Room> rooms) {
        this.level = level;
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

//    public Home getHome() {
//        return home;
//    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getLevel() {
        return level;
    }
}