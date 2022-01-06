package stuff.devices;

import house.Room;

public class PetFeeder extends Device {

    private int foodCapacity = 4;
    private boolean isEmpty = false;


    public PetFeeder(Room room) {
        super(room, "Pet Feeder", 1, 3,  2);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void nyamNyam() {
        if (foodCapacity > 0) foodCapacity--;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }

    public void refillingFeed(){
        this.foodCapacity = 4;
    }

    public boolean needRefill() {
        if (foodCapacity == 0) {
            setEmpty(true);
            notifyObserver();
            return true;
        }
        return false;
    }
}
