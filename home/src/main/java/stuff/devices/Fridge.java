package stuff.devices;

import house.Room;
import stuff.state.BrokenState;
import stuff.state.FixingState;
import stuff.state.RestingState;
import stuff.state.UsingState;

public class Fridge extends Device implements FoodContainer {

    private static final int USING_TICKS = 2;
    private static final int MAX_FOOD_CAPACITY = 2;
    private static final int RESTING_ELECTRICITY = 5;
    private static final int BROKEN_ELECTRICITY = 7;
    private static final int IN_USING_ELECTRICITY = 5;

    private int currentFoodCapacity = MAX_FOOD_CAPACITY;

    public Fridge(Room room) {
        super(USING_TICKS, room, StuffType.FRIDGE,
                RESTING_ELECTRICITY, BROKEN_ELECTRICITY, IN_USING_ELECTRICITY);
    }

    @Override
    public boolean isEmpty() {
        return currentFoodCapacity == 0;
    }

    @Override
    public int getFoodCapacity() {
        return currentFoodCapacity;
    }

    @Override
    public void refill() {
        System.out.println("Kladu kolbasu v cholodos");
        currentFoodCapacity = MAX_FOOD_CAPACITY;
        setState(new RestingState(this));
    }

    @Override
    public void usingDevice(){
        if (currentFoodCapacity == 0) {
            setState(new BrokenState(this));
            System.out.println("Food in Fridge is over");
            notifyObserver();
        } else {
            setState(new UsingState(this));
            currentFoodCapacity--;
            System.out.println("Food in Fridge is running out, my lord");
        }
        usingElectricity();
    }

    @Override
    public void eating() {
//        if (currentFoodCapacity == 0) {
//            setState(new BrokenState(this));
//            System.out.println("Food in Fridge is over");
//            isEmpty = true;
//            notifyObserver();
//        } else {
//            setState(new UsingState(this));
//            currentFoodCapacity--;
//            System.out.println("Food in Fridge is running out, my lord");
//        }
    }
}
