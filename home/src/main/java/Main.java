import creatures.CreatureFactory;
import creatures.CreaturesType;
import creatures.entities.Creature;
import house.Kitchen;
import house.Room;
import stuff.DeviceFactory;
import stuff.devices.Device;


public class Main {
    public static void main(String[] args) throws Exception {
        DeviceFactory deviceFactory = new DeviceFactory();
        CreatureFactory creatureFactory = new CreatureFactory();
        Creature papa = creatureFactory.createCreature(CreaturesType.ADULT, "Ivan", 5);
        Room kitchen = new Kitchen();
        Device fridge = deviceFactory.createDevice(kitchen, "Fridge");
        System.out.println(fridge.getElectricityUsed());
        fridge.usingElectricity();
        System.out.println(fridge.getElectricityUsed());
        System.out.println(fridge.toString());
        papa.useStuff(fridge);
        System.out.println(fridge.toString());
    }

}