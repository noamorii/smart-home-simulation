package stuff.state;

import stuff.UsableObject;

public class BrokenState implements UsableObjectState {

    UsableObject stuff;
    final private StateType type;

    public BrokenState(UsableObject stuff){
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
}