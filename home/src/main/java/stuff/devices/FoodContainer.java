package stuff.devices;

public interface FoodContainer {

    boolean isEmpty();
    void setEmpty(boolean empty);
    int getFoodCapacity();
    void refillingFeed();
    void eating();
}
