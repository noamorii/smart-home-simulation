package stuff.state;

import stuff.devices.Device;

public class UsingState implements DeviceState{

    Device device;
    final private String name;

    public UsingState(Device device){
        this.device = device;
        this.name = "UsingState";
    }

    @Override
    public String getName() {
        return name;
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
        device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInUsingState());
    }
}