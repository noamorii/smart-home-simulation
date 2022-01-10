package stuff;

import house.Room;
import stuff.devices.Manual;
import stuff.devices.StuffType;
import stuff.observe.Observed;
import stuff.observe.PositronicBrain;
import stuff.state.*;
import util.Reporter;

/**
 * Class representing objects that can be used by creatures
 */
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
    private int usedTimes = 0;
    private int brokenTimes = 0;


    /**
     * Instantiates a new UsableObject.
     *
     * @param usingTicks                use time
     * @param room                      the location
     * @param type                      the type of object used
     * @param electricityInRestingState the electricity consumption in resting state
     * @param electricityInBrokenState  the electricity consumption in broken state
     * @param electricityInUsingState   the electricity consumption in using state
     */
    protected UsableObject(int usingTicks, Room room, StuffType type,
                           int electricityInRestingState, int electricityInBrokenState, int electricityInUsingState) {

        this.usingTicks = usingTicks;
        this.currentRoom = room;
        this.type = type;

        this.electricityInRestingState = electricityInRestingState;
        this.electricityInBrokenState = electricityInBrokenState;
        this.electricityInUsingState = electricityInUsingState;
    }

    /**
     * Returns the state of the object.
     *
     * @return UsableObjectState
     */
    public UsableObjectState getCurrentState() {
        return currentState;
    }

    /**
     * Places an object in a specific state.
     *
     * @param newState the state in which the object will be placed
     */
    public void setState(UsableObjectState newState) {
        this.currentState = newState;
    }

    /**
     * Returns the type of the object.
     *
     * @return type
     */
    public StuffType getType() {
        return type;
    }

    /**
     * Returns the number of ticks in a certain state
     *
     * @return Ticks
     */
    public int getTicks() {
        if (currentState.getType() != StateType.USING) {
            return currentState.getTicks();
        }
        return usingTicks;
    }

    /**
     * Returns the number of times the object has been used.
     *
     * @return int
     */
    public int getUsedTimes() {
        return usedTimes;
    }

    /**
     * Returns the number of breakages of an object.
     *
     * @return int
     */
    public int getBrokenTimes() {
        return brokenTimes;
    }

    /**
     * Sets the number of uses.
     *
     * @param usedTimes number of uses
     */
    public void setUsedTimes(int usedTimes) {
        this.usedTimes = usedTimes;
    }

    /**
     * Returns the room where the object is located.
     *
     * @return Room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Returns electricity consumed by the object in a resting state per tick.
     *
     * @return electricity In Resting State
     */
    public int getElectricityInRestingState() {
        return electricityInRestingState;
    }

    /**
     * Returns electricity consumed by the object in a broken state per tick.
     *
     * @return electricity In Broken State
     */
    public int getElectricityInBrokenState() {
        return electricityInBrokenState;
    }

    /**
     * Returns electricity consumed by the object in a fixing state per tick.
     *
     * @return electricity In Fixing State
     */
    public int getElectricityInFixingState() {
        return ELECTRICITY_IN_FIXING;
    }

    /**
     * Returns electricity consumed by the object in a using state per tick.
     *
     * @return electricity In Using State
     */
    public int getElectricityInUsingState() {
        return electricityInUsingState;
    }

    /**
     * The amount of electricity during use.
     *
     * @return electricityUsed
     */
    public int getElectricityUsed() {
        return electricityUsed;
    }

    /**
     * Adds electricity to total electricity used.
     *
     * @param electricity electricity to be added
     */
    public void addUsedElectricity(int electricity) {
        electricityUsed += electricity;
    }

    /**
     * Using of electricity in a specific state
     */
    public void usingElectricity() {
        currentState.usingElectricity();
    }

    /**
     * Places an object in a using state.
     */
    public void usingStuff() {
        usedTimes++;
        setState(new UsingState(this));
    }

    /**
     * Resets the electricity meter.
     */
    public void resetElectricity() {
        electricityUsed = 0;
    }

    /**
     * Resets the number of uses.
     */
    public void resetUsedTimes() {
        usedTimes = 0;
    }

    /**
     * Resets the number of breakdowns.
     */
    public void resetBrokenTimes() {
        brokenTimes = 0;
    }

    /**
     * Places an object in a broken state and uses electricity.
     */
    public void breakingDevice() {
        brokenTimes++;
        setState(new BrokenState(this));
        notifyObserver();
    }

    /**
     * Places an object in a fixing state.
     */
    public void fixingDevice() {
        setState(new FixingState(this));
    }

    /**
     * Returns a manual for repairing an object.
     *
     * @return manual
     */
    public Manual getManual() {
        addEventToReport("Taking out a huge book from the shelf");
        if (manual == null) manual = new Manual(this);
        return manual;
    }

    @Override
    public void notifyObserver() {
        addEventToReport("Positronic Brain handle event with " + getType());
        PositronicBrain.getInstance().handleEvent(this);
    }


    public void addEventToReport(String event) {
        Reporter.generateEventReport(event);
    }

}
