package stuff.sport.factory;

import house.Room;
import stuff.sport.*;

import java.util.ArrayList;
import java.util.List;

public class SportFactory {
    private static SportFactory instance = null;
    private SportFactory(){}

    public static SportFactory getInstance() {
        if (instance == null) instance = new SportFactory();
        return instance;
    }

    private List<Sport> sports = new ArrayList<>();

    public Sport createSport(Room room, SportType type) throws Exception {
        Sport sport = switch (type) {
            case TREADMILL -> new Treadmill(room);
            case BIKE -> new Bike(room);
            case STEPPER -> new Stepper(room);
            case ORBITREK -> new Orbitrek(room);
            default -> throw new Exception("We don't have sport device: "+ type + " in the house");
        };
        room.addStuff(sport);
        sports.add(sport);
        return sport;
}
}