package stuff.state;

import stuff.UsableObject;

/**
 * Fixing State
 */
public class FixingState implements UsableObjectState {

    UsableObject stuff;
    final private StateType type;

    private final static int IN_FIXING_TICKS = 4;

    /**
     * Instantiates a Fixing State.
     *
     * @param stuff         Sets an object in this state.
     */
    public FixingState(UsableObject stuff){
        this.stuff = stuff;
        this.type = StateType.FIXING;
    }

    @Override
    public StateType getType() {
        return type;
    }

    @Override
    public UsableObject getUsableObject() {
        return stuff;
    }

    @Override
    public void setUsableObject(UsableObject stuff) {
        this.stuff = stuff;
    }

    @Override
    public void usingElectricity() {
        stuff.addUsedElectricity(stuff.getElectricityInFixingState());
    }

    @Override
    public int getTicks() {
        return IN_FIXING_TICKS;
    }
}