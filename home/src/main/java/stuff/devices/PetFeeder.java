package stuff.devices;

import house.Room;

public class PetFeeder extends Device implements FoodContainer {

    private static final int USING_TICKS = 4;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 3;
    private static final int IN_USING_ELECTRICITY = 2;
    private static final int MAX_FOOD_CAPACITY = 4;

    private int currentFoodCapacity = 4;
    private boolean isEmpty = false;

    public PetFeeder(Room room) {
        super(USING_TICKS, room, StuffType.PET_FEEDER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    public int getFoodCapacity() {
        return currentFoodCapacity;
    }

    @Override
    public void refill() {
        currentFoodCapacity = MAX_FOOD_CAPACITY;
    }

    @Override
    public void eating() {
        if (currentFoodCapacity > 0) {
            currentFoodCapacity--;
            System.out.println("Food in Pet Feeder is running out, my lord");
        } else {
            System.out.println("Food in Pet Feeder is over");
            isEmpty = true;
            notifyObserver();
        }
    }
}
