package stuff.devices;
import house.Room;
import stuff.UsableObject;
import stuff.devices.factory.DeviceType;
import stuff.observe.Observed;
import stuff.observe.PositronicBrain;
import stuff.state.*;

public abstract class Device extends UsableObject implements Observed{

    private final PositronicBrain positronicBrain = PositronicBrain.getInstance();
    private DeviceState currentState = new RestingState(this);

    final private DeviceType type;

    private int electricityUsed = 0;

    private final int electricityInRestingState;
    private final int electricityInBrokenState;
    private final int electricityInFixingState = 0;
    private final int electricityInUsingState;


    public Device(Room room, DeviceType type, int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState, int usingTicks){
        super(usingTicks, room);
        this.type = type;
        this.electricityInRestingState = electricityInRestingState;
        this.electricityInBrokenState = electricityInBrokenState;
        this.electricityInUsingState = electricityInUsingState;
    }

    public DeviceType getType() {
        return type;
    }

    public DeviceState getCurrentState() {
        return currentState;
    }

    public void setState(DeviceState newState) {
        this.currentState = newState;
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

    public void usingElectricity(){
        currentState.usingElectricity();
    }

    public void usingDevice(){
        setState(new UsingState(this));
        usingElectricity();
    }

    public void breakingDevice(){
        System.out.println(getType() + " is broken");
        notifyObserver();
        setState(new BrokenState(this));
        usingElectricity();
    }

    public void fixingDevice(){
        System.out.println(getType() + "is in the fixing state");
        setState(new FixingState(this));
        usingElectricity();
    }

    @Override
    public void notifyObserver() {
        System.out.println("Positronic Brain handle event with " + getType());
        positronicBrain.handleEvent(this);
    }

    @Override
    public String toString() {
        return "Device{" +
                "state=" + currentState +
                ", electricityUsed=" + electricityUsed +
                ", room=" + getCurrentRoom() +
                ", name='" + getType() + '\'' +
                ", electricityInRestingState=" + electricityInRestingState +
                ", electricityInBrokenState=" + electricityInBrokenState +
                ", electricityInFixingState=" + electricityInFixingState +
                ", electricityInUsingState=" + electricityInUsingState +
                '}';
    }
}
