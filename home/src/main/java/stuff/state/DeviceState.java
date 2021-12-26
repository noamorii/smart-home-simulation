package stuff.state;

import stuff.devices.Device;

public interface DeviceState {

    Device getDevice();

    void setDevice(Device device);

    void usingElectricity();
}
