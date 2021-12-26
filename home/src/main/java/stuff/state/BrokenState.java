package stuff.state;

import stuff.devices.Device;

public class BrokenState implements DeviceState{

    Device device;

    public BrokenState(Device device){
        this.device = device;
    }

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
        device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInBrokenState());
    }
}