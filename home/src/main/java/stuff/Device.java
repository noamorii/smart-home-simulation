package stuff;
import house.Room;
import stuff.state.DeviceState;
import stuff.state.RestingState;

public abstract class Device implements UsableObject{

    DeviceState state;
    int electricityUsed = 0;
    final private Room room;

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    public int getElectricityUsed() {
        return electricityUsed;
    }

    public void setElectricityUsed(int electricityUsed) {
        this.electricityUsed = electricityUsed;
    }

    public Device( Room room){
        this.state = new RestingState();
        this.room = room;
    }

    public void usingElectricity(){
        state.usingElectricity();
    }

}
