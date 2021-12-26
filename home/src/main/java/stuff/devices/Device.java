package stuff.devices;
import house.Room;
import stuff.UsableObject;
import stuff.state.DeviceState;
import stuff.state.RestingState;

public abstract class Device implements UsableObject {

    private DeviceState state;
    private int electricityUsed = 0;
    final private Room room;
    final private String name;
    final int electricityInRestingState;
    final int electricityInBrokenState;
    final int electricityInFixingState = 0;
    final int electricityInUsingState;


    public Device(Room room, String name, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState){
        this.name = name;
        this.electricityInRestingState = electricityInRestingState;
        this.electricityInBrokenState = electricityInBrokenState;
        this.electricityInUsingState = electricityInUsingState;
        this.state = new RestingState(this);
        this.room = room;
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    public int getElectricityInRestingState() {
        return electricityInRestingState;
    }

    public int getElectricityInBrokenState() {
        return electricityInBrokenState;
    }

    public int getElectricityInFixingState() {
        return electricityInFixingState;
    }

    public int getElectricityInUsingState() {
        return electricityInUsingState;
    }

    public int getElectricityUsed() {
        return electricityUsed;
    }

    public void setElectricityUsed(int electricityUsed) {
        this.electricityUsed = electricityUsed;
    }

    public void usingElectricity(){
        state.usingElectricity();
    }

}
