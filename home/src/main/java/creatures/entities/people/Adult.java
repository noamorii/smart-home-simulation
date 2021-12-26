package creatures.entities.people;
import creatures.CreaturesType;
import creatures.entities.Creature;
import stuff.devices.Device;

public class Adult extends Person {

    public Adult(String name, int age, CreaturesType type) {
        super(name, age, type);
    }

    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void moveTo() {
    }

    public void repairStuff(Device device) {
        device.breakingDevice();
    }

    @Override
    public void useStuff(Device device){
        device.usingDevice();
    }
}
