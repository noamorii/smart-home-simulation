package stuff.observe;

import creatures.entities.people.Adult;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;
import stuff.state.StateType;

import java.util.List;
import java.util.Random;

public class PositronicBrain implements Observer {

    DeviceFactory deviceFactory = DeviceFactory.getInstance();
    private List<Device> devices = deviceFactory.getDevices();
    private static PositronicBrain instance = null;

    private PositronicBrain() {
    }


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
            System.out.println(device.getType() + " has used " + device.getElectricityUsed() + " electricity for today");
        }
        System.out.println("All electricity used by day: " + allElectricity);
    }

    public Device adviceWhatToDo() {
        Random rand = new Random();
        int deviceCounter = devices.size() - 1;
        while (true) {
            int int_random = rand.nextInt(deviceCounter);
            Device device = devices.get(int_random);
            if (device.getCurrentState().getType().equals(StateType.RESTING)) {
                return device;
            }
            //return devices.stream().filter((d) -> d.getCurrentState().getType().equals(StateType.RESTING)).findAny().orElse(Adult.getToDoList().stream().findFirst().orElse(null));

        }
    }
}