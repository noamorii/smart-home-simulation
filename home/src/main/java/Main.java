import house.Kitchen;
import house.Room;
import stuff.devices.Device;
import stuff.devices.Fridge;
import stuff.state.RestingState;

public class Main {
    public static void main(String[] args) {
        Room kitchen = new Kitchen();
        RestingState restingState = new RestingState();
        Device fridge = new Fridge(restingState, kitchen);
        restingState.setDevice(fridge);
        System.out.println(fridge.getElectricityUsed());
        fridge.usingElectricity();
        System.out.println(fridge.getElectricityUsed());
    }

}