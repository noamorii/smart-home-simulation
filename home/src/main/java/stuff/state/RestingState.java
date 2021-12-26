package stuff.state;

import stuff.DeviceFactory;
import stuff.devices.Device;

public class RestingState implements DeviceState{

    Device device;

    public RestingState(Device device){
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
        device.setElectricityUsed(device.getElectricityUsed() + 3);
    }
}
