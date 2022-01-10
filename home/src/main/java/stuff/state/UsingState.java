package stuff.state;

import stuff.UsableObject;

/**
 * Using State
 */
public class UsingState implements UsableObjectState {

    UsableObject stuff;
    final private StateType type;

    /**
     * Instantiates a Using State.
     *
     * @param stuff Sets an object in this state.
     */
    public UsingState(UsableObject stuff) {
        this.stuff = stuff;
        this.type = StateType.USING;
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
        stuff.addUsedElectricity(stuff.getElectricityInUsingState());
    }

    @Override
    public int getTicks() {
        return stuff.getTicks();
    }
}