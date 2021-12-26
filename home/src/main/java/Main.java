import creatures.CreatureFactory;
import creatures.CreaturesType;
import creatures.entities.Creature;
import house.Home;
import house.Kitchen;
import house.Room;
import stuff.devices.Computer;
import stuff.devices.Device;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
//        DeviceFactory deviceFactory = new DeviceFactory();
//        Room kitchen = new Kitchen();
//        Device fridge = deviceFactory.createDevice(kitchen, "Fridge");
//        System.out.println(fridge.getElectricityUsed());
//        fridge.usingElectricity();
//        System.out.println(fridge.getElectricityUsed());

        List<Device> devices = new ArrayList<>();
        Room room = new Kitchen();
        Device device1 = new Computer(room);
        devices.add(device1);

        CreatureFactory creatureFactory = new CreatureFactory();
        Creature man = creatureFactory.createCreature(CreaturesType.ADULT, "Name1", 23);

        Home.HomeBuilder home = Home.newBuilder();
        Home house = home.address("aaa").devices(devices).build();


    }

}