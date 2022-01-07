package stuff.devices;

import house.Room;

public class PetFeeder extends Device implements FoodContainer {

    private int foodCapacity = 4;
    private boolean isEmpty = false;

    public PetFeeder(Room room) {
        super(room, "Pet Feeder", 1, 3, 2);
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }

    @Override
    public void refillingFeed() {
        this.foodCapacity = 4;
    }

    @Override
    public void eating() {
        if (foodCapacity > 0) {
            foodCapacity--;
            System.out.println("Food in Pet Feeder is running out, my lord");
        } else {
            System.out.println("Food in Pet Feeder is over");
            setEmpty(true);
            notifyObserver();
        }
    }
}
