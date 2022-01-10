package stuff.devices;

import house.Room;

/**
 * Interface for objects containing food.
 */
public interface FoodContainer {
    /**
     * Returns true if the container is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Replenishment of food supplies.
     */
    void refill();

    /**
     * Returns the room where the container is located.
     *
     * @return Room
     */
    Room getCurrentRoom();

    /**
     * Returns the type of the container
     *
     * @return StuffType
     */
    StuffType getType();
}
