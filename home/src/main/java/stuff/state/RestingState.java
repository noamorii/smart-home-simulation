package stuff.state;

import stuff.devices.Device;

public class RestingState implements DeviceState{

    Device device;
    final private String name;

    public RestingState(Device device){
        this.device = device;
        this.name = "RestingState";
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
        device.setElectricityUsed(device.getElectricityUsed() + device.getElectricityInRestingState());
    }
}