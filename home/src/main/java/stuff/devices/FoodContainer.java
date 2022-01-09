package stuff.devices;

import house.Room;
import stuff.UsableObject;

public interface FoodContainer {

    boolean isEmpty();
    int getFoodCapacity();
    void refill();
    void eating();
    Room getCurrentRoom();
    StuffType getType();
}
