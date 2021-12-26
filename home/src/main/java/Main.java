import house.Kitchen;
import house.Room;
import stuff.DeviceFactory;
import stuff.devices.Device;


public class Main {
    public static void main(String[] args) throws Exception {
        DeviceFactory deviceFactory = new DeviceFactory();
        Room kitchen = new Kitchen();
        Device fridge = deviceFactory.createDevice(kitchen, "Fridge");
        System.out.println(fridge.getElectricityUsed());
        fridge.usingElectricity();
        System.out.println(fridge.getElectricityUsed());
    }

}