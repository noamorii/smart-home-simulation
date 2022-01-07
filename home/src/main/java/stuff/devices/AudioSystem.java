package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class AudioSystem extends Device{

    private static final int USING_TICKS = 2;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 6;
    private static final int IN_USING_ELECTRICITY = 4;

    public AudioSystem(Room room) {
        super(room, DeviceType.AUDIO_SYSTEM,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY,  IN_USING_ELECTRICITY, USING_TICKS);
    }
}
