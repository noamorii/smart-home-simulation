package stuff.devices;
import house.Room;
import stuff.UsableObject;
import stuff.observe.Observed;
import stuff.observe.PositronicBrain;
import stuff.state.*;

public abstract class Device implements UsableObject, Observed{

    private static final PositronicBrain positronicBrain = new PositronicBrain();
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
    public String getName() {
        return name;
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

    public Room getRoom() {
        return room;
    }

    public void usingElectricity(){
        state.usingElectricity();
    }

    public void usingDevice(){
        setState(new UsingState(this));
    }

    public void breakingDevice(){
        System.out.println(this.getName() + " is broken");
        notifyObserver();
        setState(new BrokenState(this));
    }

    public void fixingDevice(){
        System.out.println(this.getName() + "is in the fixing state");
        setState(new FixingState(this));
    }

    @Override
    public void notifyObserver() {
        System.out.println("Positronic Brain handle event with " + this.getName());
        positronicBrain.handleEvent(this);
    }

    @Override
    public String toString() {
        return "Device{" +
                "state=" + state +
                ", electricityUsed=" + electricityUsed +
                ", room=" + room +
                ", name='" + name + '\'' +
                ", electricityInRestingState=" + electricityInRestingState +
                ", electricityInBrokenState=" + electricityInBrokenState +
                ", electricityInFixingState=" + electricityInFixingState +
                ", electricityInUsingState=" + electricityInUsingState +
                '}';
    }
}
