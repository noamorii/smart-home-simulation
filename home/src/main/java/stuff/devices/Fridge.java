package stuff.devices;

import house.Room;
import stuff.devices.factory.DeviceType;

public class Fridge extends Device implements FoodContainer {

    private static final int USING_TICKS = 2;
    private static final int MAX_FOOD_CAPACITY = 10;
    private static final int RESTING_ELECTRICITY = 5;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 5;

    private int currentFoodCapacity = MAX_FOOD_CAPACITY;

    private boolean isEmpty = false;

    public Fridge(Room room) {
        super(room, DeviceType.FRIDGE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY, USING_TICKS);
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public int getFoodCapacity() {
        return currentFoodCapacity;
    }

    @Override
    public void refillingFeed() {
        currentFoodCapacity = MAX_FOOD_CAPACITY;
    }

    @Override
    public void eating() {
        if (currentFoodCapacity > 0) {
            currentFoodCapacity--;
            System.out.println("Food in Fridge is running out, my lord");
        } else {
            System.out.println("Food in Fridge is over");
            isEmpty = true;
            notifyObserver();
        }
    }
}
