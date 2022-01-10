package stuff.state;

import stuff.UsableObject;

/**
 * Broken State
 */
public class BrokenState implements UsableObjectState {

    private final static int BROKEN_TICKS = 0;

    UsableObject stuff;
    final private StateType type;

    /**
     * Instantiates a Broken State.
     *
     * @param stuff Sets an object in this state.
     */
    public BrokenState(UsableObject stuff) {
        this.stuff = stuff;
        this.type = StateType.BROKEN;
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
        stuff.addUsedElectricity(stuff.getElectricityInBrokenState());
    }

    @Override
    public int getTicks() {
        return BROKEN_TICKS;
    }
}