package stuff.observe;

import creatures.entities.people.Adult;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;

public class PositronicBrain implements Observer{

    private static PositronicBrain instance = null;
    private PositronicBrain(){};

    public static PositronicBrain getInstance() {
        if (instance == null) instance = new PositronicBrain();
        return instance;
    }

    @Override
    public void handleEvent(Device device) {
        Adult.getToDoList().add(device);
    }
}
