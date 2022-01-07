package stuff.state;

import stuff.devices.Device;

public class FixingState implements DeviceState{

    Device device;
    final private StateType type;

    public FixingState(Device device){
        this.device = device;
        this.type = StateType.FIXING;
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

    }

    @Override
    public void usingElectricity() {
        device.addUsedElectricity(device.getElectricityUsed() + device.getElectricityInFixingState());
    }
}
