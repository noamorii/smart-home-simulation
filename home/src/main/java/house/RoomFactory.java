package house;

public class RoomFactory {

    public RoomImpl createRoom(String name) throws Exception {
        return switch (name) {
            case "Kitchen" -> new RoomImpl("Kitchen");
            case "Parents' bedroom" -> new RoomImpl("Parents' bedroom");
            case "Children's bedroom" -> new RoomImpl("Children's bedroom");
            case "Garage" -> new RoomImpl("Garage");
            case "Living room" -> new RoomImpl("Living room");
            case "Hallway" -> new RoomImpl("Hallway");
            default -> throw new Exception("This room does not exist");
        };
    }
}
