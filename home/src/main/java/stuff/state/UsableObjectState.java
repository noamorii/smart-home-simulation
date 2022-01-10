package stuff.state;

import stuff.UsableObject;

/**
 * Interface for object status
 */
public interface UsableObjectState {
    /**
     * Returns the status of the object.
     *
     * @return StateType
     */
    StateType getType();

    /**
     * Returns an object that is in this state.
     *
     * @return UsableObject
     */
    UsableObject getUsableObject();

    /**
     * Sets an object in this state.
     *
     * @param usableObject              the object to be placed in this status
     */
    void setUsableObject(UsableObject usableObject);

    /**
     * Using of electricity in this state
     */
    void usingElectricity();

    /**
     * Time spent in this status
     *
     * @return int
     */
    int getTicks();
}
