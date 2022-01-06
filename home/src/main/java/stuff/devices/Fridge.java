package stuff.devices;

import house.Room;

public class Fridge extends Device {

    private int foodCapacity = 10;
    private boolean isEmpty = false;

    public Fridge(Room room) {
        super(room, "Fridge", 5, 7,  5);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void eating() {
        if (foodCapacity > 0) {
            foodCapacity--;
            System.out.println();
        }
        else {
            System.out.println("Food in Fridge is over");
            needRefill();
        }
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
