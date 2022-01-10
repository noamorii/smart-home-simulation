
import house.Home;
import house.Room;
import util.Config;
import util.Simulation;

public class Main {

    public static void main(String[] args) throws Exception {

        Config config = new Config();
        Home home = config.configureHouse("configuration2.json");
        System.out.println("--------------------s"+ home.getFloors().get(0).getRooms());
        for (Room room : home.getFloors().get(0).getRooms()) {
            System.out.println(room.getStuff());
        }
        Simulation simulation = config.getSimulation();
        simulation.run();
    }
}