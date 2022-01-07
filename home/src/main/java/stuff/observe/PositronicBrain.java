package stuff.observe;

import creatures.entities.people.Adult;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;
import stuff.devices.factory.DeviceFactory;

import java.util.List;

public class PositronicBrain implements Observer {

    DeviceFactory deviceFactory = DeviceFactory.getInstance();
    private List<Device> devices = deviceFactory.getDevices();
    private static PositronicBrain instance = null;
    private PositronicBrain(){}


    public static PositronicBrain getInstance() {
        if (instance == null) instance = new PositronicBrain();
        return instance;
    }

    @Override
    public void handleEvent(Device device) {
        Adult.getToDoList().add(device);
    }

    public void generateReportAboutElectricityUsedByDay() {
        int allElectricity = 0;
        for (Device device : devices) {
            allElectricity += device.getElectricityUsed();
            System.out.println(device.getName() + " has used " + device.getElectricityUsed() + " electricity for today" );
        }
        System.out.println("All electricity used by day: " + allElectricity);
    }

    public Device adviceWhatToDo() {
        return devices.stream().filter((s) -> s.getState().getName().equals("RestingState")).findAny().orElse(Adult.getToDoList().stream().findFirst().orElse(null));
    }
}