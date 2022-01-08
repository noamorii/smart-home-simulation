package stuff.state;

import stuff.UsableObject;

public interface UsableObjectState {

    StateType getType();

    UsableObject getUsableObject();

    void setUsableObject(UsableObject usableObject);

    void usingElectricity();

    int getTicks();
}
