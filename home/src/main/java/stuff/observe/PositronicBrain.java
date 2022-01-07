package stuff.observe;

import creatures.entities.people.Adult;
import stuff.devices.Device;

public class PositronicBrain implements Observer{

    @Override
    public void handleEvent(Device device) {
        Adult.getToDoList().add(device);
    }
}
