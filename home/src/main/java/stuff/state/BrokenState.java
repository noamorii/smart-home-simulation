package stuff.state;

import stuff.devices.Device;

public class BrokenState implements DeviceState{

    Device device;
    final private StateType type;

    public BrokenState(Device device){
        this.device = device;
        this.type = StateType.BROKEN;
    }

    @Override
    public StateType getType() {
        return type;
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
        device.addUsedElectricity(device.getElectricityInBrokenState());
    }
}