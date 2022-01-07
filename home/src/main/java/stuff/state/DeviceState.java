package stuff.state;

import stuff.devices.Device;

public interface DeviceState {

    StateType getType();

    Device getDevice();

    void setDevice(Device device);

    void usingElectricity();
}
