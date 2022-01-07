package stuff.devices;

import house.Room;

public class Fridge extends Device implements FoodContainer {

    private int foodCapacity = 10;
    private boolean isEmpty = false;

    public Fridge(Room room) {
        super(room, "Fridge", 5, 7, 5);
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public int getFoodCapacity() {
        return foodCapacity;
    }

    @Override
    public void refillingFeed() {
        this.foodCapacity = 10;
    }

    @Override
    public void eating() {
        if (foodCapacity > 0) {
            foodCapacity--;
            System.out.println("Food in Fridge is running out, my lord");
        } else {
            System.out.println("Food in Fridge is over");
            setEmpty(true);
            notifyObserver();
        }
    }
}
