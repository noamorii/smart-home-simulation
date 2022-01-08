package creatures.entities.people;

import creatures.factories.CreaturesType;
import house.Room;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.observe.PositronicBrain;

import java.util.Random;

public class Child extends Person {

    public Child(String name, int age, Room room, CreaturesType type) {
        super(name, age, room, type);
    }

    public void say() {
        System.out.println("Crying...");
    }

    @Override
    public void useStuff(UsableObject usableObject){
        System.out.println(this.getName() + " says: I am using " + usableObject.getType());
        moveTo(usableObject.getCurrentRoom());
        Random rand = new Random();
        int upperbound = 11;
        int int_random = rand.nextInt(upperbound);
        if (int_random > 7) {
            brakeStuff(usableObject);
        } else {
            usableObject.usingDevice();
        }
    }

    @Override
    public void findActivity() {
        PositronicBrain positronicBrain = PositronicBrain.getInstance();
        useStuff(positronicBrain.adviceWhatToDoFor(this));
    }

    @Override
    public void brakeStuff(UsableObject usableObject) {
        System.out.println(this.getName() + " says: I broke " + usableObject.getType());
        moveTo(usableObject.getCurrentRoom());
        System.out.println("Moooooooooom!");
        usableObject.breakingDevice();
    }

}
