package stuff.devices;

import house.Room;

public class PetFeeder extends Device {

    private int foodCapacity = 4;

    public PetFeeder(Room room) {
        super(room, "Pet Feeder", 1, 3,  2);
    }

    public void nyamNyam() {
        if (foodCapacity > 0) foodCapacity--;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }

    public boolean needRefill() {
        if (foodCapacity == 0) {
            //obs.
        }
        return false;
    }
}
