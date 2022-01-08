package house;

import stuff.UsableObject;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<UsableObject> usableObjects = new ArrayList<>();

    public Room(String name){
        this.name = name;
    }

    public List<UsableObject> getStuff() {
        return usableObjects;
    }

    public void setStuff(List<UsableObject> usableObjects) {
        this.usableObjects = usableObjects;
    }

    public void addStuff(UsableObject stuff){
        usableObjects.add(stuff);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
