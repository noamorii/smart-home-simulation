package stuff.state;

import stuff.devices.Device;

public interface DeviceState {

    String getName();

    Device getDevice();

    void setDevice(Device device);

    void usingElectricity();
}
