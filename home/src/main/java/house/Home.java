package house;

import creatures.entities.Creature;
import stuff.Auto;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents Home
 */
public class Home {

    private static Home instance = null;

    private final String address;
    private final List<Floor> floors;
    private final List<Creature> creatures;
    private final Auto auto;

    /**
     * Instantiates a new Home.
     *
     * @param builder        home builder
     */
    private Home(HomeBuilder builder) {
        address = builder.address;
        floors = builder.floors;
        creatures = builder.creatures;
        auto = builder.auto;
        instance = this;
    }

    /**
     * Returns the instance ot the Home Builder.
     *
     * @return HomeBuilder
     */
    public static HomeBuilder newBuilder() {
        if (instance != null) {
            throw new IllegalStateException("Home has already been built.");
        }
        return new HomeBuilder();
    }

    public static Home getInstance() {
        return instance;
    }

    public String getAddress() {
        return address;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    /**
     *  Returns list of all of the creatures
     *
     * @return List of Creature
     */
    public static List<Creature> getCreatures() {
        return instance.creatures;
    }

    /**
     * Method for leaving home method
     *
     * @param creature   creature to be removed from home
     */
    public void goOut(Creature creature) {
        creatures.remove(creature);
    }

    /**
     * Method to return home
     *
     * @param creature creature to be brought home
     */
    public void comeBackHome(Creature creature) {
        creatures.add(creature);
    }

    /**
     * Returns auto
     *
     * @return Auto
     */
    public Auto getAuto() {
        return auto;
    }

    /*================BUILDER===================*/

    /**
     *  Class represents Home Builder
     */
    public static final class HomeBuilder {

        private String address;
        private List<Floor> floors = new ArrayList<>();
        private List<Creature> creatures;
        private Auto auto;

        /**
         * Private singleton constructor
         */
        private HomeBuilder(){}

        public HomeBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         *  Setting list of floors.
         *
         * @param floors      list of floors
         * @return HomeBuilder
         */
        public HomeBuilder addFloors(List<Floor> floors) {
            this.floors = floors;
            return this;
        }

        public HomeBuilder addFloor(Floor floor) {
            this.floors.add(floor);
            return this;
        }

        /**
         * Setting list of creatures.
         *
         * @param creatures    list of creatures
         * @return             HomeBuilder
         */
        public HomeBuilder addCreatures(List<Creature> creatures) {
            this.creatures = creatures;
            return this;
        }

        /**
         * Setting auto
         *
         * @param auto     Auto
         * @return HomeBuilder
         */
        public HomeBuilder addAuto(Auto auto) {
            this.auto = auto;
            return this;
        }

        /**
         * Method that returns a ready-made instance at home
         *
         * @return Home
         */
        public Home build() {
            return new Home(this);
        }
    }
}

