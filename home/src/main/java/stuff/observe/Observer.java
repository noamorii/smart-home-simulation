package stuff.observe;

import stuff.devices.Device;

public interface Observer {

    void handleEvent(Device device);
}
