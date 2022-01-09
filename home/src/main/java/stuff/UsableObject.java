package stuff;

import house.Room;
import stuff.devices.Manual;
import stuff.devices.StuffType;
import stuff.observe.Observed;
import stuff.observe.PositronicBrain;
import stuff.state.*;

public abstract class UsableObject implements Observed {

    private final int usingTicks;
    private final StuffType type;

    private Manual manual;
    private final Room currentRoom;
    private UsableObjectState currentState = new RestingState(this);

    private final static int ELECTRICITY_IN_FIXING = 0;

    private int electricityUsed = 0;
    private final int electricityInRestingState;
    private final int electricityInBrokenState;
    private final int electricityInUsingState;

    protected UsableObject(int usingTicks, Room room, StuffType type,
           int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState) {

        this.usingTicks = usingTicks;
        this.currentRoom = room;
        this.type = type;

        this.electricityInRestingState = electricityInRestingState;
        this.electricityInBrokenState = electricityInBrokenState;
        this.electricityInUsingState = electricityInUsingState;

    }

    public UsableObjectState getCurrentState() {
        return currentState;
    }

    public void setState(UsableObjectState newState) {
        this.currentState = newState;
    }

    public StuffType getType() {
        return type;
    }

    public int getTicks() {
        if (currentState.getType() != StateType.USING) {
            return currentState.getTicks();
        }
        return usingTicks;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getElectricityInRestingState() {
        return electricityInRestingState;
    }

    public int getElectricityInBrokenState() {
        return electricityInBrokenState;
    }

    public int getElectricityInFixingState() {
        return ELECTRICITY_IN_FIXING;
    }

    public int getElectricityInUsingState() {
        return electricityInUsingState;
    }

    public int getElectricityUsed() {
        return electricityUsed;
    }

    public void addUsedElectricity(int electricity) {
        electricityUsed += electricity;
    }

    public void usingElectricity() {
        currentState.usingElectricity();
    }

    public void usingStuff() {
        setState(new UsingState(this));
        usingElectricity();
    }

    public void breakingDevice(){
        setState(new BrokenState(this));
        notifyObserver();
        usingElectricity();
    }

    public void fixingDevice(){
        setState(new FixingState(this));
        usingElectricity();
    }

    public Manual getManual() {
        System.out.println("Taking out a huge book from the shelf");
        if (manual == null) manual = new Manual(this);
        return manual;
    }

    @Override
    public void notifyObserver() {
        System.out.println("Positronic Brain handle event with " + getType());
        PositronicBrain.getInstance().handleEvent(this);
    }

}
