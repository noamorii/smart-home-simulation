package house;

import stuff.devices.Device;

import java.util.List;

public class Room {

    private String name;
    private List<Device> devices;

    public Room(String name){
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}