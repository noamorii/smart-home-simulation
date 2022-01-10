package util;

import creatures.entities.Creature;
import creatures.factories.CreaturesType;
import creatures.factories.PeopleFactory;
import creatures.factories.PetFactory;
import house.Floor;
import house.Home;
import house.Room;
import house.RoomFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import stuff.Auto;
import stuff.devices.StuffType;
import stuff.devices.factory.DeviceFactory;
import stuff.sport.factory.SportFactory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Config {

    private final DeviceFactory deviceFactory = DeviceFactory.getInstance();
    private final SportFactory sportFactory = SportFactory.getInstance();
    private final RoomFactory roomFactory = new RoomFactory();
    private final PetFactory petFactory = PetFactory.getInstance();
    private final PeopleFactory peopleFactory = PeopleFactory.getInstance();
    private final Home.HomeBuilder home = Home.newBuilder();

    private Simulation simulation = null;

    public void configureHouse(String fileName) throws Exception {

        Object level = new JSONParser().parse(new FileReader(fileName));
        JSONObject levelObj = (JSONObject) level;

        String[] order = new String[]{"home", "creatures", "simulation"};

        for (String element : order) {
            loadJson(element, levelObj);
        }

        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(petFactory.getPets());
        creatures.addAll(peopleFactory.getPeople());

        home.addCreatures(creatures).addAuto(new Auto(new Room("Auto-Garage"))).build();
    }

    private void loadJson(String element, JSONObject levelObj) throws Exception {

        JSONArray array = (JSONArray) levelObj.get(element);

        switch (element) {

            case "simulation" -> {
                JSONObject sim = (JSONObject) array.get(0);
                this.simulation = new Simulation(((Long) sim.get("iterations")).intValue(), sim.get("starting_time").toString());
            }
            case "home" -> {
                home.address((String) ((JSONObject) array.get(0)).get("address"));
                for (Object floor : (JSONArray) ((JSONObject) array.get(0)).get("floors")) {
                    Floor new_floor = new Floor(((Long) (((JSONObject) floor).get("level"))).intValue());

                    home.addFloor(new_floor);

                    JSONArray rooms = (JSONArray) ((JSONObject) floor).get("rooms");

                    for (Object room : rooms) {

                        Room new_room = roomFactory.create((String) ((JSONObject) room).get("name"));
                        new_floor.addRoom(new_room);
                        JSONArray staff = (JSONArray) ((JSONObject) room).get("staff");

                        JSONArray sport_staff = (JSONArray) (((JSONObject) staff.get(0)).get("sport"));
                        if (!sport_staff.isEmpty()) {
                            for (Object sport : sport_staff) {
                                sportFactory.createSport(new_room, StuffType.getTypeByName((String) ((JSONObject) sport).get("type")));
                            }
                        }
                        JSONArray devices_staff = (JSONArray) (((JSONObject) staff.get(0)).get("devices"));
                        if (!devices_staff.isEmpty()) {
                            for (Object device : devices_staff) {
                                deviceFactory.createDevice(new_room, StuffType.getTypeByName((String) ((JSONObject) device).get("type")));
                            }
                        }
                    }
                }
            }
            case "creatures" -> {
                JSONArray pets = (JSONArray) ((JSONObject) array.get(0)).get("pets");
                if (!pets.isEmpty()) {
                    JSONArray cats = (JSONArray) (((JSONObject) (pets.get(0))).get("cats"));
                    if (!cats.isEmpty()) {
                        for (Object cat : cats) {
                            petFactory.create(CreaturesType.CAT, (String) (((JSONObject) cat).get("name")),
                                    ((Long) (((JSONObject) cat).get("age"))).intValue(), (String) (((JSONObject) cat).get("breed")),
                                    roomFactory.findRoomByName((String) (((JSONObject) cat).get("room"))));
                        }
                    }
                    JSONArray parrots = (JSONArray) (((JSONObject) (pets.get(0))).get("parrots"));
                    if (!parrots.isEmpty()) {
                        for (Object parrot : parrots) {
                            petFactory.create(CreaturesType.PARROT, (String) (((JSONObject) parrot).get("name")),
                                    ((Long) (((JSONObject) parrot).get("age"))).intValue(), (String) (((JSONObject) parrot).get("breed")),
                                    roomFactory.findRoomByName((String) (((JSONObject) parrot).get("room"))));
                        }
                    }
                }
                JSONArray people = (JSONArray) ((JSONObject) array.get(0)).get("people");
                if (!people.isEmpty()) {
                    JSONArray adults = (JSONArray) (((JSONObject) (people.get(0))).get("adults"));
                    if (!adults.isEmpty()) {
                        for (Object adult : adults) {
                            peopleFactory.create(CreaturesType.ADULT, (String) (((JSONObject) adult).get("name")),
                                    ((Long) (((JSONObject) adult).get("age"))).intValue(), roomFactory.findRoomByName((String) (((JSONObject) adult).get("room"))));
                        }
                    }
                    JSONArray children = (JSONArray) (((JSONObject) (people.get(1))).get("children"));
                    if (!children.isEmpty()) {
                        for (Object child : children) {
                            peopleFactory.create(CreaturesType.CHILD, (String) (((JSONObject) child).get("name")),
                                    ((Long) (((JSONObject) child).get("age"))).intValue(),
                                    roomFactory.findRoomByName((String) (((JSONObject) child).get("room"))));
                        }
                    }
                }
            }
        }
    }

    public Simulation getSimulation() {
        return simulation;
    }
}
