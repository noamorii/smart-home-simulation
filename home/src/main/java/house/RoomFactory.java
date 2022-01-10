package house;

public class RoomFactory {

    /**
     * Factory method that creates rooms.
     *
     * @param name           room's name
     * @return Room
     */
    public Room create(String name) throws Exception {
        return switch (name) {
            case "Kitchen" -> new Room("Kitchen");
            case "Parents' bedroom" -> new Room("Parents' bedroom");
            case "Children's bedroom" -> new Room("Children's bedroom");
            case "Garage" -> new Room("Garage");
            case "Living room" -> new Room("Living room");
            case "Hallway" -> new Room("Hallway");
            default -> throw new Exception("This room does not exist");
        };
    }
}
