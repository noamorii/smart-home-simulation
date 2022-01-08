package stuff;

import house.Room;

public abstract class UsableObject {

    private final int usingTicks;
    private Room currentRoom;

    protected UsableObject(int usingTicks, Room room) {
        this.usingTicks = usingTicks;
        this.currentRoom = room;
    }

    public int getUsingTicks() {
        return usingTicks;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
