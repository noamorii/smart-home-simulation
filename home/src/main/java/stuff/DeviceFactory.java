package stuff;

import house.Room;
import stuff.devices.*;

public class DeviceFactory {

    public Device createDevice(Room room, String name) throws Exception {
        return switch (name) {
            case "Computer" -> new Computer(room);

            case "Fridge" -> new Fridge(room);

            case "Smart Vacuum" -> new SmartVacuum(room);

            case "Air Conditioner" -> new AirConditioner(room);

            case "Audio System" -> new AudioSystem(room);

            case "Pet Feeder" -> new PetFeeder(room);

            case "Smart Phone" -> new SmartPhone(room);

            case "TV" -> new TV(room);

            default -> throw new Exception("We don't have device: "+ name + " in the house");
        };
    }
}
