package house;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {

    private final List<Room> rooms = new ArrayList<>();

    /**
     * Factory method that creates rooms.
     *
     * @param name room's name
     * @return Room
     */
    public Room create(String name) throws Exception {
        Room room = switch (name) {
            case "Kitchen" -> new Room("Kitchen");
            case "Parents' bedroom" -> new Room("Parents' bedroom");
            case "Children's bedroom" -> new Room("Children's bedroom");
            case "Garage" -> new Room("Garage");
            case "Living room" -> new Room("Living room");
            case "Hallway" -> new Room("Hallway");
            case "Dancing room" -> new Room("Dancing room");
            case "Workplace" -> new Room("Workplace");
            case "Guest room" -> new Room("Guest room");
            default -> throw new Exception("This room does not exist");
        };
        rooms.add(room);
        return room;
    }

    public Room findRoomByName(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) return room;
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
