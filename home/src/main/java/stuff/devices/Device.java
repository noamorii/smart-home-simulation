package stuff.devices;
import house.Room;
import stuff.UsableObject;
import stuff.observe.Observed;

public abstract class Device extends UsableObject implements Observed{

    public Device(int usingTicks, Room room, StuffType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState){
        super(usingTicks, room, type, electricityInRestingState, electricityInBrokenState, electricityInUsingState);
    }

}
