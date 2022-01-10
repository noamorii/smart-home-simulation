package stuff.devices.factory;

import house.Room;
import stuff.devices.*;

import java.util.ArrayList;
import java.util.List;

public class DeviceFactory {

    private static DeviceFactory instance = null;

    /**
     * Private singleton constructor
     */
    private DeviceFactory(){}

    /**
     * Returns the instance ot the Device Factory.
     *
     * @return instance
     */
    public static DeviceFactory getInstance() {
        if (instance == null) instance = new DeviceFactory();
        return instance;
    }

    /**
     * List of all devices.
     */
    private final List<Device> devices = new ArrayList<>();

    /**
     * Factory method that creates devices and adds it to the list.
     *
     * @param room                  the location
     * @param type                  device's type
     * @return device
     */
    public Device createDevice(Room room, StuffType type) throws Exception {
        Device device = switch (type) {
            case COMPUTER -> new Computer(room);
            case PET_TOY -> new PetToy(room);
            case FRIDGE -> new Fridge(room);
            case VACUUM -> new SmartVacuum(room);
            case CONDITIONER -> new AirConditioner(room);
            case AUDIO_SYSTEM -> new AudioSystem(room);
            case PET_FEEDER -> new PetFeeder(room);
            case PHONE -> new SmartPhone(room);
            case TV -> new TV(room);
            default -> throw new Exception("We don't have device: "+ type + " in the house");
        };

        room.addStuff(device);
        devices.add(device);
        return device;
    }

    /**
     * Returns list of all devices.
     *
     * @return List<Sport>
     */
    public List<Device> getDevices() {
        return devices;
    }
}
