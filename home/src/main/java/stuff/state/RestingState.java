package stuff.state;

import stuff.devices.Device;

public class RestingState implements DeviceState{

    Device device;
    final private StateType type;

    public RestingState(Device device){
        this.device = device;
        this.type = StateType.RESTING;
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
        device.addUsedElectricity(device.getElectricityUsed() + device.getElectricityInRestingState());
    }
}