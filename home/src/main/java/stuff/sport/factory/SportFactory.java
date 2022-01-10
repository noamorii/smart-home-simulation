package stuff.sport.factory;

import house.Room;
import stuff.devices.StuffType;
import stuff.sport.*;

import java.util.ArrayList;
import java.util.List;

public class SportFactory {

    private static SportFactory instance = null;

    /**
     * Private singleton constructor
     */
    private SportFactory() {
    }

    /**
     * Returns the instance ot the Sport Factory.
     *
     * @return instance
     */
    public static SportFactory getInstance() {
        if (instance == null) instance = new SportFactory();
        return instance;
    }

    /**
     * List of all sports equipment
     */
    private final List<Sport> sports = new ArrayList<>();

    /**
     * Returns list of all sports equipment.
     *
     * @return List of Sport
     */
    public List<Sport> getSports() {
        return sports;
    }

    /**
     * Factory method that creates sports equipment and adds it to the list.
     *
     * @param room the location
     * @param type sports equipment's type
     * @return sport equipment
     */
    public Sport createSport(Room room, StuffType type) throws Exception {
        Sport sport = switch (type) {
            case TREADMILL -> new Treadmill(room);
            case BIKE -> new Bike(room);
            case STEPPER -> new Stepper(room);
            case ORBITREK -> new Orbitrek(room);
            default -> throw new Exception("We don't have sport device: " + type + " in the house");
        };
        room.addStuff(sport);
        sports.add(sport);
        return sport;
    }
}
