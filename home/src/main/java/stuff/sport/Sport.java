package stuff.sport;

import house.Room;
import stuff.UsableObject;
import stuff.devices.StuffType;

import java.io.IOException;

public abstract class Sport extends UsableObject {

    public Sport(int usingTicks, Room room, StuffType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState) throws IOException {
        super(usingTicks, room, type, electricityInRestingState, electricityInBrokenState, electricityInUsingState);
    }
}
