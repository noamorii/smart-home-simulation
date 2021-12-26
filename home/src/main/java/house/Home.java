package house;

import creatures.entities.Creature;
import stuff.devices.Device;

import java.util.List;

public class Home {

    private static Home instance = null;

    private final String address;
    private final List<Room> rooms;
    private final List<Floor> floors;
    private final List<Creature> creatures;
    private final List<Device> devices;

    private Home(HomeBuilder builder) {
        address = builder.address;
        rooms = builder.rooms;
        floors = builder.floors;
        creatures = builder.creatures;
        devices = builder.devices;
        instance = this;
    }

    public static Home getInstance() {
        return instance;
    }

    public static HomeBuilder newBuilder() {
        if (instance != null) {
            throw new IllegalStateException("Device has already been built.");
        }
        return new HomeBuilder();
    }

    public static String address() {
        return instance.address;
    }

    public static List<Room> rooms() {
        return instance.rooms;
    }

    public static List<Floor> floors() {
        return instance.floors;
    }

    public static List<Creature> creatures() {
        return instance.creatures;
    }

    public static List<Device> devices() {
        return instance.devices;
    }

    /*===================================*/

    public static final class HomeBuilder {
        private String address;
        private List<Room> rooms;
        private List<Floor> floors;
        private List<Creature> creatures;
        private List<Device> devices;

        private HomeBuilder(){
        }

        public HomeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public HomeBuilder rooms(List<Room> rooms) {
            this.rooms = rooms;
            return this;
        }

        public HomeBuilder floors(List<Floor> floors) {
            this.floors = floors;
            return this;
        }

        public HomeBuilder creatures(List<Creature> creatures) {
            this.creatures = creatures;
            return this;
        }

        public HomeBuilder devices(List<Device> devices) {
            this.devices = devices;
            return this;
        }

        public Home build() {
            return new Home(this);
        }
    }
}

