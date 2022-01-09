package stuff.devices;

import house.Room;
import stuff.state.BrokenState;
import stuff.state.RestingState;
import stuff.state.UsingState;

public class PetFeeder extends Device implements FoodContainer {

    private static final int USING_TICKS = 2;
    private static final int RESTING_ELECTRICITY = 1;
    private static final int BROKEN_ELECTRICITY = 3;
    private static final int IN_USING_ELECTRICITY = 2;
    private static final int MAX_FOOD_CAPACITY = 4;

    private int currentFoodCapacity = 10;
    private boolean isEmpty = false;

    public PetFeeder(Room room) {
        super(USING_TICKS, room, StuffType.PET_FEEDER,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public boolean isEmpty() {
        return currentFoodCapacity == 0;
    }

    public int getFoodCapacity() {
        return currentFoodCapacity;
    }

    @Override
    public void refill() {
        currentFoodCapacity = MAX_FOOD_CAPACITY;
        setState(new RestingState(this));
    }

    @Override
    public void usingDevice(){
        if (currentFoodCapacity <= 0) {
            setState(new BrokenState(this));
            System.out.println("Food in Pet Feeder is over");
            isEmpty = true;
            notifyObserver();
        } else {
            setState(new UsingState(this));
            currentFoodCapacity--;
            System.out.println("Food in Pet Feeder is running out, my lord");
        }
        usingElectricity();
    }

    @Override
    public void eating() {
//        if (currentFoodCapacity <= 0) {
//            setState(new BrokenState(this));
//            System.out.println("Food in Pet Feeder is over");
//            isEmpty = true;
//            notifyObserver();
//        } else {
//            setState(new UsingState(this));
//            currentFoodCapacity--;
//            System.out.println("Food in Pet Feeder is running out, my lord");
//        }
    }
}
