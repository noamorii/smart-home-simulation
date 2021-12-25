package stuff;

import house.Room;
import stuff.state.DeviceState;

public class Fridge extends Device{

    public Fridge(DeviceState state, Room room) {
        super(room);
    }

}
