package stuff.devices;

import house.Room;

public interface FoodContainer {

    boolean isEmpty();

    void refill();

    Room getCurrentRoom();

    StuffType getType();
}
