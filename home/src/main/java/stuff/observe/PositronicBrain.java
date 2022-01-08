package stuff.observe;

import creatures.entities.Creature;
import creatures.entities.people.Adult;
import creatures.factories.CreaturesType;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;
import stuff.state.StateType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PositronicBrain implements Observer {

    private final List<Device> devices;
    private static PositronicBrain instance = null;

    private final List<Device> devicesForPets = new ArrayList<>();
    private final List<Device> devicesForHumans = new ArrayList<>();

    private PositronicBrain() {

        devices = DeviceFactory.getInstance().getDevices();

        for (Device device: devices) {
            switch (device.getType()) {
                case CONDITIONER, AUDIO_SYSTEM,
                     COMPUTER, FRIDGE, PHONE -> devicesForHumans.add(device);
                case PET_FEEDER, PET_TOY -> devicesForPets.add(device);
                default -> {
                    devicesForPets.add(device);
                    devicesForHumans.add(device);
                }
            }
        }
    }

    public static PositronicBrain getInstance() {
        if (instance == null) instance = new PositronicBrain();
        return instance;
    }

    public Device adviceWhatToDoFor(Creature creature) {
        if (creature.getMainCreatureType() == CreaturesType.PET)
            return getRandomFreeDevice(devicesForPets);
        return getRandomFreeDevice(devicesForHumans);
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

    public Device getRandomFreeDevice(List<Device> devices) {
        int randomIndexOfList = new Random().nextInt(devices.size());
        List<Device> freeDevices = devices.stream()
                .filter(device -> device.getCurrentState().getType() == StateType.RESTING)
                .collect(Collectors.toList());
        return freeDevices.get(randomIndexOfList);
    }
}