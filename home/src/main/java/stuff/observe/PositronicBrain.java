package stuff.observe;

import creatures.entities.Creature;
import creatures.entities.people.Adult;
import creatures.factories.CreaturesType;
import house.Home;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;
import stuff.sport.Sport;
import stuff.sport.factory.SportFactory;
import stuff.state.StateType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PositronicBrain implements Observer {

    public FileWriter myWriter = new FileWriter("src/main/resources/Report.txt");
    private final List<Device> devices;
    private static PositronicBrain instance = null;

    private final List<Device> devicesForPets = new ArrayList<>();
    private final List<Device> devicesForHumans = new ArrayList<>();
    private static int dayCounter = 1;

    private PositronicBrain() throws IOException {

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

    public static PositronicBrain getInstance() throws IOException {
        if (instance == null) instance = new PositronicBrain();
        return instance;
    }

    public Device adviceDeviceFor(Creature creature) {
        if (creature.getMainCreatureType() == CreaturesType.PET)
            return getRandomFreeDevice(devicesForPets);
        return getRandomFreeDevice(devicesForHumans);
    }

    @Override
    public void handleEvent(UsableObject stuff) {
        Adult.addTask(stuff);
    }

    public void generateReportAboutElectricityUsedByDay() throws IOException {
        int allElectricity = 0;
        myWriter.write("_________________ Report for the " + dayCounter + " day _________________\n");
        for (Device device : devices) {
            allElectricity += device.getElectricityUsed();
            myWriter.write(device.getType() + " has used " + device.getElectricityUsed() + " electricity for today. " +
                    "Was used " + device.getUsedTimes() + " times. " +
                     "Was broken " + device.getBrokenTimes() + " times.\n");
            device.resetElectricity();
            device.resetUsedTimes();
            device.resetBrokenTimes();
        }
        myWriter.write("On " + Home.getInstance().getAuto().getType() + " Adults go for food " + Home.getInstance().getAuto().getUsedTimes() + " times \n");
        myWriter.write("All electricity used by day: " + allElectricity + "\n");
        myWriter.flush();
        Home.getInstance().getAuto().setUsedTimes(0);
        dayCounter++;
    }

    public Device getRandomFreeDevice(List<Device> devices) {
        List<Device> freeDevices = devices.stream()
                .filter(device -> device.getCurrentState().getType() == StateType.RESTING)
                .collect(Collectors.toList());

        if (freeDevices.isEmpty()) {
            return null;
        }

        int randomIndexOfList = new Random().nextInt(freeDevices.size());
        return freeDevices.get(randomIndexOfList);
    }

    public Sport getRandomFreeSport() {
        List<Sport> freeSports = SportFactory.getInstance().getSports().stream()
                .filter(device -> device.getCurrentState().getType() == StateType.RESTING)
                .collect(Collectors.toList());

        if (freeSports.isEmpty()) {
            return null;
        }

        int randomIndexOfList = new Random().nextInt(freeSports.size());
        return freeSports.get(randomIndexOfList);
    }
}