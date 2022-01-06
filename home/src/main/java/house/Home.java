package house;

import creatures.entities.Creature;
import java.util.List;

public class Home {

    private static Home instance = null;

    private final String address;
    private final List<Floor> floors;
    private final List<Creature> creatures;

    private Home(HomeBuilder builder) {
        address = builder.address;
        floors = builder.floors;
        creatures = builder.creatures;
        instance = this;
    }

    public static Home getInstance() {
        return instance;
    }

    public static HomeBuilder newBuilder() {
        if (instance != null) {
            throw new IllegalStateException("Home has already been built.");
        }
        return new HomeBuilder();
    }

    public static String address() {
        return instance.address;
    }

    public static List<Floor> floors() {
        return instance.floors;
    }

    public static List<Creature> creatures() {
        return instance.creatures;
    }

    /*================BUILDER===================*/

    public static final class HomeBuilder {

        private String address;
        private List<Floor> floors;
        private List<Creature> creatures;

        private HomeBuilder(){
        }

        public HomeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public HomeBuilder addFloors(List<Floor> floors) {
            this.floors = floors;
            return this;
        }

        public HomeBuilder addCreatures(List<Creature> creatures) {
            this.creatures = creatures;
            return this;
        }

        public Home build() {
            return new Home(this);
        }
    }
}

