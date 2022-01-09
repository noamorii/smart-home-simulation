package stuff.devices;

import house.Room;
import stuff.state.RestingState;
import stuff.state.UsingState;

public class Fridge extends Device implements FoodContainer {

    private static final int USING_TICKS = 2;
    private static final int MAX_FOOD_CAPACITY = 1;
    private static final int RESTING_ELECTRICITY = 5;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 5;

    private int currentFoodCapacity = MAX_FOOD_CAPACITY;

    private boolean isEmpty = false;

    public Fridge(Room room) {
        super(USING_TICKS, room, StuffType.FRIDGE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
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
        setState(new RestingState(this));
        currentFoodCapacity = MAX_FOOD_CAPACITY;
    }

    @Override
    public void eating() {
        setState(new UsingState(this));

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
