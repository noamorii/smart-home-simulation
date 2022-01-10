package stuff.devices;

import house.Room;
import stuff.UsableObject;

/**
 * Class representing device.
 */
public abstract class Device extends UsableObject {
    /**
     * The instance ot Device.
     *
     * @param room the location
     */
    public Device(int usingTicks, Room room, StuffType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState) {
        super(usingTicks, room, type, electricityInRestingState, electricityInBrokenState, electricityInUsingState);
    }

}
