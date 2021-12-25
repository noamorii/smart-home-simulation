package stuff.state;

import stuff.Device;

public interface DeviceState {

    Device device = null;

    Device getDevice();

    void setDevice(Device device);

    void usingElectricity();
}
