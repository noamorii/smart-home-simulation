package stuff.state;

import stuff.devices.Device;

public interface DeviceState {

    Device device = null;

    Device getDevice();

    void setDevice(Device device);

    void usingElectricity();
}
