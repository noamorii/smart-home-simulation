package stuff.state;

import stuff.Device;

public class UsingState implements DeviceState{

    Device device;

    @Override
    public Device getDevice() {
        return device;
    }

    @Override
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public void usingElectricity() {
        device.setElectricityUsed(device.getElectricityUsed() + 10);
    }
}
