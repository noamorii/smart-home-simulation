package stuff.state;

import stuff.devices.Device;

public class UsingState implements DeviceState{

    Device device;

    public UsingState(Device device){
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
        //device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInUsingState());
    }
}