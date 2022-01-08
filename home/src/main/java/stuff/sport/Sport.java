package stuff.sport;

import house.Room;
import stuff.UsableObject;
import stuff.devices.StuffType;

public abstract class Sport extends UsableObject{

    public Sport(int usingTicks, Room room, StuffType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState){
        super(usingTicks, room, type, electricityInRestingState, electricityInBrokenState, electricityInUsingState);
    }
}
