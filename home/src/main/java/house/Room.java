package house;

import stuff.UsableObject;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;

    /**
     * List of all usable objects in the room
     */
    private List<UsableObject> usableObjects = new ArrayList<>();

    /**
     * Instantiates a new Room.
     *
     * @param name room's name
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * Returns list of all usable objects in the room
     *
     * @return List of UsableObject
     */
    public List<UsableObject> getStuff() {
        return usableObjects;
    }

    /**
     * Returns list of all usable objects in the room
     *
     * @param usableObjects usable objects in the room
     */
    public void setStuff(List<UsableObject> usableObjects) {
        this.usableObjects = usableObjects;
    }

    /**
     * Adding usable object to the room
     *
     * @param stuff added object
     */
    public void addStuff(UsableObject stuff) {
        usableObjects.add(stuff);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
