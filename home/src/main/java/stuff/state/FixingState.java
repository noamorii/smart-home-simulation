package stuff.state;

import stuff.devices.Device;

public class FixingState implements DeviceState{

    Device device;
    final private String name;

    public FixingState(Device device){
        this.device = device;
        this.name = "FixingState";
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

    }

    @Override
    public void usingElectricity() {
        device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInFixingState());
    }
}
