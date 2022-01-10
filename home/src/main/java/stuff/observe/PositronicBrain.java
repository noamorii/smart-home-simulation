package stuff.observe;

import creatures.entities.Creature;
import creatures.entities.people.Adult;
import creatures.factories.CreaturesType;
import stuff.UsableObject;
import stuff.devices.Device;
import stuff.devices.factory.DeviceFactory;
import stuff.sport.Sport;
import stuff.sport.factory.SportFactory;
import stuff.state.StateType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class representing the central home control system
 */
public class PositronicBrain implements Observer {

    private static PositronicBrain instance = null;

    private final List<Device> devicesForPets = new ArrayList<>();
    private final List<Device> devicesForHumans = new ArrayList<>();

    /**
     * Private singleton constructor that creates lists of devices for people and pets
     */
    private PositronicBrain() {

        List<Device> devices = DeviceFactory.getInstance().getDevices();

        for (Device device : devices) {
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

    /**
     * Returns the instance ot the Positronic Brain
     *
     * @return instance
     */
    public static PositronicBrain getInstance() {
        if (instance == null) instance = new PositronicBrain();
        return instance;
    }

    /**
     * Helps the creature choose a free device to use
     *
     * @param creature creature that will receive advice
     * @return device
     */
    public Device adviceDeviceFor(Creature creature) {
        if (creature.getMainCreatureType() == CreaturesType.PET)
            return getRandomFreeDevice(devicesForPets);
        return getRandomFreeDevice(devicesForHumans);
    }

    @Override
    public void handleEvent(UsableObject stuff) {
        Adult.addTask(stuff);
    }

    /**
     * Sport
     *
     * @param devices list of all devices in the house
     * @return Device
     */
    private Device getRandomFreeDevice(List<Device> devices) {
        List<Device> freeDevices = devices.stream()
                .filter(device -> device.getCurrentState().getType() == StateType.RESTING)
                .collect(Collectors.toList());

        if (freeDevices.isEmpty()) {
            return null;
        }

        int randomIndexOfList = new Random().nextInt(freeDevices.size());
        return freeDevices.get(randomIndexOfList);
    }

    /**
     * Returns a random free sports equipment
     *
     * @return Sport
     */
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