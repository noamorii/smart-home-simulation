package stuff.state;

import stuff.devices.Device;

public class FixingState implements DeviceState{

    Device device;

    public FixingState(Device device){
        this.device = device;
    }

    @Override
    public Device getDevice() {
        return device;
    }

    @Override
    public void setDevice(Device device) {

    }

    @Override
    public void usingElectricity() {
        device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInFixingState());
    }
}
