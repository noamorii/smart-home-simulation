package stuff.devices;
import house.Room;
import stuff.UsableObject;

public abstract class Device extends UsableObject {

    public Device(int usingTicks, Room room, StuffType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState){
        super(usingTicks, room, type, electricityInRestingState, electricityInBrokenState, electricityInUsingState);
    }

}
