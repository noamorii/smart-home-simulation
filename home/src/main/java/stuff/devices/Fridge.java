package stuff.devices;

import house.Room;

public class Fridge extends Device {

    public Fridge(Room room) {
        super(room, "Fridge", 5, 7,  5);
    }

    public String sayHelloToMyLittleFriend(){
        return "Hi";
    }

}
